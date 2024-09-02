package pages;

import Utility.SeleniumUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends SeleniumUtility {
    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//*/div/div[2]/div/div/div/div/div")
    public WebElement InvalidLoginError;

    @FindBy(xpath = "//*/div/div[2]/div/div/div/h2")
    public WebElement SignInText;

    @FindBy(name = "username")
    public WebElement UserName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(className = "css-jut409")
    public WebElement SignInBTN;

}
