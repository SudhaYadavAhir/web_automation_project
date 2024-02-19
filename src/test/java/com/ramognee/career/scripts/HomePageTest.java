package com.ramognee.career.scripts;

import com.aventstack.extentreports.Status;
import com.ramognee.career.generic.BaseTestClass;
import com.ramognee.career.generic.ExcelUtil;
import com.ramognee.career.pagewise.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class HomePageTest extends BaseTestClass {

    HomePage homePage;
    ExcelUtil excelUtil;

    @Test
    public void tc01_launchBrowser() throws Exception {
        extentTest = extent.createTest("TC01: launch browser");
        extentTest.assignAuthor("Sudha");
        homePage = new HomePage(driver);
        excelUtil = new ExcelUtil();
        homePage.clickOnFromTextBox();
        homePage.clearDataFromFromTextBox();
        homePage.enterValueInFromFromTextBox();
        homePage.selectStationFromDropDown();
        homePage.selectDateFromSortOnDateCalender();
        excelUtil.writeDataExcelSheet(homePage.getDropdownStationName());
        ArrayList arrAct=excelUtil.readDataExcelSheet("src/main/resources/ActualStationName.xlsx");
        System.out.println(arrAct);
        ArrayList arrexp=excelUtil.readDataExcelSheet("src/main/resources/ExpectedStationName.xlsx");
        Assert.assertEquals(arrAct,arrexp);
        extentTest.log(Status.INFO, "Browser launch is verified successfully");

    }
}
