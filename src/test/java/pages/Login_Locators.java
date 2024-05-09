package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Login_Locators {

    public Login_Locators(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='nav-link-accountList-nav-line-1']")
    public WebElement loginNavButton;

    @FindBy(xpath = "//*[@class='a-spacing-small']")
    public WebElement loginPageConfirmHeader;

    @FindBy(xpath = "//*[@id='ap_email']")
    public WebElement loginPageEmailTextbox;

    @FindBy(xpath = "(//*[@id='continue'])[1]")
    public WebElement loginPageContinueButton;

    @FindBy(xpath = "//*[@id='ap_password']")
    public WebElement loginPagePasswordTextbox;

    @FindBy(xpath = "//*[@id='signInSubmit']")
    public WebElement loginPageLoginButton;

    @FindBy(xpath = "//*[@class='a-unordered-list a-nostyle a-vertical a-spacing-none']")
    public WebElement LoginPageInvalidEmailErrorMessage;

    @FindBy(xpath = "//*[@id='nav-global-location-popover-link']")
    public WebElement LoginPageLoginSuccessConfirmation;

    @FindBy(xpath = "(//*[@class='a-alert-content'])[3]")
    public WebElement LoginPageEmptyTextboxErrorMessage;


}
