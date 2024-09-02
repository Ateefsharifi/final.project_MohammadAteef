package pages;

import Utility.SeleniumUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfile extends SeleniumUtility {
    public UserProfile(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(id = "chakra-modal-:re:")
    public WebElement ProfileMenu;

    @FindBy(className = "css-1at26de")
    public WebElement CustomerServicePortal;

    @FindBy(className = "css-1lzp9bh")
    public WebElement Profile;

    @FindBy(css = "body > div:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) " +
            "> div:nth-child(4) > div:nth-child(1) > " +
            "div:nth-child(1) > div:nth-child(4) > p:nth-child(2)")
    public WebElement SideMenuUserName;

    @FindBy(className = "css-1ik4h6n")
    public WebElement SideMenuProfileClose;

    @FindBy(className = "css-1x18d5s")
    public WebElement UserProfileLogOut;

}
