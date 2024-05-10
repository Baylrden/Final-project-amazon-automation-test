package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Searchbar_Locators {
    public Searchbar_Locators(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    public WebElement searchbarElement;

    @FindBy(xpath = "//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']")
    public WebElement categoryDropdown;

}
