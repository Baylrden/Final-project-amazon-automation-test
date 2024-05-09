package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login_Locators;
import pages.SignUp_Locators;
import utilities.ConfigReader;
import utilities.Driver;

public class SignUp_Page_Tests {

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


    }

    @Test(description = "Verify that user can not sign up without email address")
    public void TC_03(){


    }

    @Test(description = "Verify that user can't sign up without password ")
    public void TC_04(){

    }

    @Test(description = "Verify that condition of use page displaying correctly after clicking on link")
    public void TC_05(){

    }

    @Test(description = "Verify that user can not use less than 6 characters for password")
    public void TC_06(){

    }

    @Test(description = "Verify that user can not use already signed up email address while sign up process")
    public void TC_07(){

    }

    @Test(description = "Verify that user can not sign up with email without domain section")
    public void TC_08(){

    }

    @Test(description = "Verify that login link leads to login page after clicking")
    public void TC_09(){

    }

    @Test(description = "Verify that user can not sign up without password confirmation")
    public void TC_10(){

    }

    @Test(description = "Verify that user can not sign up without filling name section")
    public void TC_11(){

    }

    @Test(description = "Verify that clicking on amazon logo leads to Amazon homepage")
    public void TC_12(){


    }


    @Test(description = "Verify that user can sign up successfully with valid datas")
    public void TC_13(){

    }

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }
}

