package tests;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login_Locators;
import pages.SignUp_Locators;
import utilities.ConfigReader;
import utilities.Driver;

public class SignUp_Page_Tests {

    private static final Logger log = LoggerFactory.getLogger(SignUp_Page_Tests.class);
    static WebDriver driver;

    SignUp_Locators signUpLocators = new SignUp_Locators();
    Login_Locators loginLocators = new Login_Locators();

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        loginLocators.loginNavButton.click();
        signUpLocators.signUpNavButton.click();

    }

    @Test(description = "Verify that sign up page displaying correctly.")
    public void TC_01(){

        String expectedHeader = "Hesap oluşturun";
        String actualHeader = signUpLocators.signUpHeaderText.getText();

        Assert.assertEquals(actualHeader,expectedHeader);

    }

    @Test(description = "Verify that user can not use emoji in email section ")
    public void TC_02(){

        loginLocators.loginPageEmailTextbox.sendKeys("gerardoyle01🇹🇷@gmail.com");

        loginLocators.loginPageContinueButton.click();

        Assert.assertTrue(signUpLocators.signUpEmptyEmailErrorMessage.isDisplayed());

    }

    @Test(description = "Verify that user can not sign up without email address")
    public void TC_03(){

        signUpLocators.signUpNameTextbox.sendKeys(ConfigReader.getProperty("signUpName"));

        loginLocators.loginPagePasswordTextbox.sendKeys(ConfigReader.getProperty("validPassword"));
        signUpLocators.signUpPasswordConfirmTextbox.sendKeys(ConfigReader.getProperty("validPassword"));

        loginLocators.loginPageContinueButton.click();

        Assert.assertFalse(signUpLocators.signUpEmptyEmailErrorMessage.isDisplayed());

    }

    @Test(description = "Verify that user can't sign up without password ")
    public void TC_04(){

        signUpLocators.signUpNameTextbox.sendKeys(ConfigReader.getProperty("signUpName"));

        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("validEmail"));

        loginLocators.loginPageContinueButton.click();

        Assert.assertTrue(signUpLocators.signUpEmptyPasswordErrorMessage.isDisplayed());

    }

    @Test(description = "Verify that user can not sign up when password and confirm password fields has different texts")
    public void TC_05(){

        signUpLocators.signUpNameTextbox.sendKeys(ConfigReader.getProperty("signUpName"));

        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("validEmail"));

        loginLocators.loginPagePasswordTextbox.sendKeys(ConfigReader.getProperty("validPassword"));
        signUpLocators.signUpPasswordConfirmTextbox.sendKeys("DifferentPassword");

        loginLocators.loginPageContinueButton.click();

        Assert.assertTrue(signUpLocators.signUpPasswordsDoesnotMatchErrorMessage.isDisplayed());

    }

    @Test(description = "Verify that user can not use less than 6 characters for password")
    public void TC_06(){

        signUpLocators.signUpNameTextbox.sendKeys(ConfigReader.getProperty("signUpName"));

        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("validEmail"));

        loginLocators.loginPagePasswordTextbox.sendKeys("Less6");
        signUpLocators.signUpPasswordConfirmTextbox.sendKeys("Less6");

        loginLocators.loginPageContinueButton.click();

        Assert.assertTrue(signUpLocators.signUpLessPasswordErrorMessage.isDisplayed());

    }

    @Test(description = "Verify that user can not use already signed up email address while sign up process")
    public void TC_07(){

        signUpLocators.signUpNameTextbox.sendKeys(ConfigReader.getProperty("signUpName"));

        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("alreadyInUseEmail"));

        loginLocators.loginPagePasswordTextbox.sendKeys(ConfigReader.getProperty("validPassword"));
        signUpLocators.signUpPasswordConfirmTextbox.sendKeys(ConfigReader.getProperty("validPassword"));

        loginLocators.loginPageContinueButton.click();

        Assert.assertTrue(signUpLocators.signUpAlreadyInUseMessage.isDisplayed());


    }

    @Test(description = "Verify that user can not sign up with email without domain section")
    public void TC_08(){

        signUpLocators.signUpNameTextbox.sendKeys(ConfigReader.getProperty("signUpName"));

        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("invalidEmailWithoutDomain"));

        loginLocators.loginPagePasswordTextbox.sendKeys(ConfigReader.getProperty("validPassword"));
        signUpLocators.signUpPasswordConfirmTextbox.sendKeys(ConfigReader.getProperty("validPassword"));

        loginLocators.loginPageContinueButton.click();

        Assert.assertTrue(signUpLocators.signUpEmptyEmailErrorMessage.isDisplayed());


    }

    @Test(description = "Verify that login link leads to login page after clicking")
    public void TC_09(){

        signUpLocators.signUpPageLoginLink.click();

        String expectedText= "Giriş yap";
        String actualText= signUpLocators.loginPageConfirmationText.getText();

        Assert.assertEquals(actualText,expectedText);

    }

    @Test(description = "Verify that user can not sign up without password confirmation")
    public void TC_10(){

        signUpLocators.signUpNameTextbox.sendKeys(ConfigReader.getProperty("signUpName"));

        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("validEmail"));

        loginLocators.loginPagePasswordTextbox.sendKeys(ConfigReader.getProperty("validPassword"));

        loginLocators.loginPageContinueButton.click();

        Assert.assertTrue(signUpLocators.signUpEmptyConfirmPasswordMessage.isDisplayed());

    }

    @Test(description = "Verify that user can not sign up without filling name section")
    public void TC_11(){

        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("validEmail"));

        loginLocators.loginPagePasswordTextbox.sendKeys(ConfigReader.getProperty("validPassword"));
        signUpLocators.signUpPasswordConfirmTextbox.sendKeys(ConfigReader.getProperty("validPassword"));

        loginLocators.loginPageContinueButton.click();

        Assert.assertTrue(signUpLocators.signUpEmptyNameMessage.isDisplayed());
    }

    @Test(description = "Verify that clicking on amazon logo leads to Amazon homepage")
    public void TC_12(){

        signUpLocators.signUpAmazonLogo.click();

        Assert.assertTrue(loginLocators.LoginPageLoginSuccessConfirmation.isDisplayed());
    }


   /* @Test(description = "Verify that user can sign up successfully with valid datas")
    public void TC_13(){

        signUpLocators.signUpNameTextbox.sendKeys(ConfigReader.getProperty("signUpName"));

        loginLocators.loginPageEmailTextbox.sendKeys(ConfigReader.getProperty("signUpValidEmail"));

        loginLocators.loginPagePasswordTextbox.sendKeys(ConfigReader.getProperty("validPassword"));
        signUpLocators.signUpPasswordConfirmTextbox.sendKeys(ConfigReader.getProperty("validPassword"));

        loginLocators.loginPageContinueButton.click();

        ReusableMethods.wait(5);

        Assert.assertFalse(loginLocators.loginPageContinueButton.isDisplayed());

    }*/

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }
}

