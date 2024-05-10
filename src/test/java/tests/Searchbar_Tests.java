package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public void setup() {
        driver = Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Test(description = "Verify that searchbar element displaying correctly.")
    public void TC_01() {
        Assert.assertTrue(searchbarLocators.searchbarElement.isDisplayed());

    }

    @Test(description = "Verify that all categories displaying when clicking on dropdown")
    public void TC_02() {

        searchbarLocators.categoryDropdown.click();

        List<String> dropdownElements = ReusableMethods.stringListeCevir(searchbarLocators.dropdownValues);

        Assert.assertEquals(dropdownElements.size(), 21);

    }

    @Test(description = "Verify that dropdown categories including 'Bebek'")
    public void TC_03() {

        searchbarLocators.categoryDropdown.click();
        List<String> dropdownElements = ReusableMethods.stringListeCevir(searchbarLocators.dropdownValues);

        String expectedValue = "Bebek";

        Assert.assertTrue(dropdownElements.contains(expectedValue));

    }

    @Test(description = "Verify that no result is displaying when searching only special character")
    public void TC_04() {

        searchbarLocators.searchbarElement.sendKeys("♕⚂ ⚂ ⚂ ⚂ ⚂ ⚂" + Keys.ENTER);

        String labelTextContains = "sonuç yok";
        String actualLabelText = searchbarLocators.noResultLabel.getText();
        Assert.assertTrue(actualLabelText.contains(labelTextContains));
    }

    @Test(description = "Verify that results are relative when searching with special character+text")
    public void TC_05() {

        searchbarLocators.searchbarElement.sendKeys("army tank♕♖♕" + Keys.ENTER);

        String expectedContains = "tank";

        for (int i = 0; i < searchbarLocators.searchResultsText.size() - 1; i++) {

            Assert.assertTrue(searchbarLocators.searchResultsText.get(i).getText().toLowerCase().contains(expectedContains));

        }

    }

    @Test(description = "Verify that past searches are visible when clicking on searchbar")
    public void TC_06() {

        searchbarLocators.searchbarElement.click();
        List<String> searchbarSuggestionsStringList = ReusableMethods.stringListeCevir(searchbarLocators.searchbarSuggestions);

        Assert.assertFalse(searchbarSuggestionsStringList.isEmpty());

    }

    @Test(description = "Verify that 10x trending suggestions are visible when clicking on searchbar")
    public void TC_07() {

        searchbarLocators.searchbarElement.click();

        List<String> trendingSuggestionsStringList = ReusableMethods.stringListeCevir(searchbarLocators.searchbarTrendingSuggestions);

        int expected = 10;

        int actual = trendingSuggestionsStringList.size();

        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Verify that there is no result when searching with random characters")
    public void TC_08() {

        searchbarLocators.searchbarElement.sendKeys("asdfghjklkjhgfd" + Keys.ENTER);

        String labelTextContains = "sonuç yok";
        String actualLabelText = searchbarLocators.noResultLabel.getText();
        Assert.assertTrue(actualLabelText.contains(labelTextContains));
    }

    @Test(description = "Verify that relative results are displaying with valid product search")
    public void TC_09() {

        searchbarLocators.searchbarElement.sendKeys("kolye" + Keys.ENTER);

        String expectedContains = "kolye";

        for (int i = 0; i < searchbarLocators.searchResultsText.size() - 55; i++) {

            Assert.assertTrue(searchbarLocators.searchResultsText.get(i).getText().toLowerCase().contains(expectedContains));

        }


    }

    @Test(description = "Verify that results containing at least one words when searching for non-existing product")
    public void TC_10() {

        searchbarLocators.searchbarElement.sendKeys("amazon white" + Keys.ENTER);

        String expectedContains1 = "amazon";
        String expectedContains2 = "white";

        for (int i = 0; i < searchbarLocators.searchResultsText.size() - 40; i++) {

            Assert.assertTrue(searchbarLocators.searchResultsText.get(i).getText().toLowerCase().contains(expectedContains1)
                    || searchbarLocators.searchResultsText.get(i).getText().toLowerCase().contains(expectedContains2));

        }

    }


    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }
}
