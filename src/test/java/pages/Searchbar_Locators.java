package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.xml.xpath.XPath;
import java.util.List;

public class Searchbar_Locators {
    public Searchbar_Locators(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    public WebElement searchbarElement;

    @FindBy(xpath = "//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']")
    public WebElement categoryDropdown;

    @FindBy(xpath = "//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']//option")
    public List<WebElement> dropdownValues;

    @FindBy(xpath = "(//*[@class='a-size-base a-color-base'])[2]")
    public WebElement noResultLabel;

    @FindBy(xpath = "//*[@class='a-size-base-plus a-color-base a-text-normal']")
    public List<WebElement> searchResultsText;

    @FindBy(xpath = "//*[@class='s-suggestion-container']")
    public List<WebElement> searchbarSuggestions;

    @FindBy(xpath = "//*[@class='s-suggestion-trending-container']")
    public List<WebElement> searchbarTrendingSuggestions;

}
