package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Searchbar_Locators {
    public Searchbar_Locators(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
