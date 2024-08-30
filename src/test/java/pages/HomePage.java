package pages;

import Utility.SeleniumUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends SeleniumUtility {

    public HomePage() {
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(className = "css-1jp0m7c")
    public WebElement CreatePrimaryAccount;



}
