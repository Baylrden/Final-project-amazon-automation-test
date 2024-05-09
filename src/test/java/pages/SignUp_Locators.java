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
}
