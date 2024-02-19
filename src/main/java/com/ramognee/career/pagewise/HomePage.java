package com.ramognee.career.pagewise;

import com.ramognee.career.generic.WaitStatement;
import com.ramognee.career.objectrepository.HomePageOR;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;

public class HomePage extends HomePageOR {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnFromTextBox(){
        elementForFromTextBox.click();
    }

    public void clearDataFromFromTextBox(){
        elementForFromTextBox.clear();
    }

    public void enterValueInFromFromTextBox() {
        elementForFromTextBox.sendKeys("DEL");
    }

    public void selectStationFromDropDown(){
        String station = elementForListOfStationName.get(3).getAttribute("title");
        System.out.println("4th station is "+station);
        elementForListOfStationName.get(3).click();
    }

    public WebElement getSelectingDateFromSortOnDate(){
        String value = elementForSelectedDateFromSortOnDate.getText();
        int intValue = Integer.valueOf(value)-1;
        return driver.findElement(By.xpath("(//td[text()='"+intValue+"'])[2]"));
    }

    public void selectDateFromSortOnDateCalender(){
        elementForSelectedDate.click();
        WaitStatement.explicitWaitForVisibilityOfElement(driver, 10, getSelectingDateFromSortOnDate());
        getSelectingDateFromSortOnDate().click();
        WaitStatement.explicitWaitForVisibilityOfElement(driver, 10, elementForSelectedDate);
        Assert.assertTrue(elementForSelectedDate.getText().contains(elementForSelectedDateFromSortOnDate.getText()));
    }
    public ArrayList<String> getDropdownStationName(){
        ArrayList<String> stationNameList= new ArrayList<String>();
        for (WebElement element:elementForListOfStationName) {
            stationNameList.add(element.getAttribute("title"));
        }
        return stationNameList;
    }


}
