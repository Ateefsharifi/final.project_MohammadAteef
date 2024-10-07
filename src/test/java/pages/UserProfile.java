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
    public WebElement customerServicePortal;

    @FindBy(className = "css-1lzp9bh")
    public WebElement profile;

    @FindBy(xpath = "//div[@data-focus-lock-disabled='false']//div[4]//p[2]")
    public WebElement sideMenuUserName;

    @FindBy(className = "css-1ik4h6n")
    public WebElement sideMenuProfileClose;

    @FindBy(xpath = "//button[normalize-space()='Logout']")
    public WebElement userProfileLogOutBtn;

}
