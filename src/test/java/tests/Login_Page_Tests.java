package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login_Locators;
import utilities.ConfigReader;
import utilities.Driver;

public class Login_Page_Tests {

    static WebDriver driver;

    Login_Locators loginLocators = new Login_Locators();

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        loginLocators.loginNavButton.click();

    }



    @Test
    public void TC_01(){

        Assert.assertEquals(loginLocators.loginPageConfirmHeader.getText(), "Giriş yap");

    }

    @Test
    public void TC_02(){

        Assert.assertTrue(loginLocators.loginPageEmailTextbox.isDisplayed());

        loginLocators.loginPageEmailTextbox.sendKeys("gerardoyle01@gmail.com");
        loginLocators.loginPageContinueButton.click();

        Assert.assertTrue(loginLocators.loginPagePasswordTextbox.isDisplayed());

        Assert.assertTrue(loginLocators.loginPageLoginButton.isDisplayed());


    }



    @Test
    public void TC_03() {


        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("invalidEmail"));
        loginLocators.loginPageContinueButton.click();

        Assert.assertTrue(loginLocators.LoginPageInvalidEmailErrorMessage.isDisplayed());
    }

    @Test
    public void TC_04(){


        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("validEmail"));
        loginLocators.loginPageContinueButton.click();

        loginLocators.loginPagePasswordTextbox.sendKeys(ConfigReader.getProperty("invalidPassword"));
        loginLocators.loginPageLoginButton.click();

        Assert.assertTrue(loginLocators.LoginPageInvalidEmailErrorMessage.isDisplayed());


    }

    @Test
    public void TC_05(){

        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("validEmail"));
        loginLocators.loginPageContinueButton.click();

        loginLocators.loginPageLoginButton.click();
        Assert.assertTrue(loginLocators.LoginPageEmptyTextboxErrorMessage.isDisplayed());

    }

    @Test
    public void TC_06(){

        loginLocators.loginPageContinueButton.click();

        Assert.assertTrue(loginLocators.LoginPageEmptyTextboxErrorMessage.isDisplayed());

    }

    @Test
    public void TC_07(){

        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("validEmail")+"♔");
        loginLocators.loginPageContinueButton.click();

        Assert.assertTrue(loginLocators.LoginPageInvalidEmailErrorMessage.isDisplayed());

    }

    @Test
    public void TC_08(){


        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("invalidEmailWithoutDomain"));

        loginLocators.loginPageContinueButton.click();

        Assert.assertTrue(loginLocators.LoginPageInvalidEmailErrorMessage.isDisplayed());

    }

    @Test
    public void TC_09(){


        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("validEmail"));

        loginLocators.loginPageContinueButton.click();

        loginLocators.loginPagePasswordTextbox.sendKeys(ConfigReader.getProperty("validPassword"));

        loginLocators.loginPageLoginButton.click();

        Assert.assertTrue(loginLocators.LoginPageLoginSuccessConfirmation.isDisplayed());

    }

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }
}
