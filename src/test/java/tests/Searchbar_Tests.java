package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Searchbar_Locators;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class Searchbar_Tests {

    Searchbar_Locators searchbarLocators = new Searchbar_Locators();

    static WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Test
    public void TC01() {

searchbarLocators.categoryDropdown.click();


        // Dropdown öğelerini bulun
        List<WebElement> options = new Select(searchbarLocators.categoryDropdown).getOptions();

        // Her dropdown öğesinin görünür olduğunu kontrol edin
        for (WebElement option : options) {
            Assert.assertTrue(option.isDisplayed());
        }







    }





    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }
}
