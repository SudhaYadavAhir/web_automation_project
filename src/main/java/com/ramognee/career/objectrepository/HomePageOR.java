package com.ramognee.career.objectrepository;

import com.ramognee.career.generic.WaitStatement;
import com.ramognee.career.locators.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageOR implements HomePageLocators {

    public HomePageOR(WebDriver driver){;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = fromTextBox)
    protected WebElement elementForFromTextBox;
    @FindBys({@FindBy(xpath = listOfStationName)})
    protected List<WebElement> elementForListOfStationName;
    @FindBy(xpath = selectedDateFromSortOnDate)
    protected WebElement elementForSelectedDateFromSortOnDate;
    @FindBy(xpath = selectedDate)
    protected WebElement elementForSelectedDate;
}
