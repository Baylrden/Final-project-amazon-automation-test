package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUp_Locators {

    public SignUp_Locators(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='createAccountSubmit']")
    public WebElement signUpNavButton;

    @FindBy(xpath = "//*[@class='a-spacing-small']")
    public WebElement signUpHeaderText;

    @FindBy(xpath = "//*[@id='ap_customer_name']")
    public WebElement signUpNameTextbox;

    @FindBy(xpath = "(//*[@class='a-alert-content'])[4]")
    public WebElement signUpEmptyEmailErrorMessage;

    @FindBy(xpath = "//*[@id='ap_password_check']")
    public WebElement signUpPasswordConfirmTextbox;

    @FindBy(xpath = "(//*[@class='a-alert-content'])[9]")
    public WebElement signUpEmptyPasswordErrorMessage;

    @FindBy(xpath = "(//*[@class='a-alert-content'])[12]")
    public WebElement signUpPasswordsDoesnotMatchErrorMessage;

    @FindBy(xpath = "(//*[@class='a-alert-content'])[10]")
    public WebElement signUpLessPasswordErrorMessage;

    @FindBy(xpath = "//*[@class='a-list-item']")
    public WebElement signUpAlreadyInUseMessage;

    @FindBy(xpath = "(//*[@class='a-link-emphasis'])")
    public WebElement signUpPageLoginLink;

    @FindBy(xpath = "//*[@class='a-spacing-small']")
    public WebElement loginPageConfirmationText;

    @FindBy(xpath = "(//*[@class='a-alert-content'])[11]")
    public WebElement signUpEmptyConfirmPasswordMessage;

    @FindBy(xpath = "(//*[@class='a-alert-content'])[2]")
    public WebElement signUpEmptyNameMessage;

    @FindBy(xpath = "//*[@class='a-icon a-icon-logo']")
    public WebElement signUpAmazonLogo;

}
