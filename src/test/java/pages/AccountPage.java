package pages;
import Utility.SeleniumUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends SeleniumUtility {

    public AccountPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//div[contains(text(),'Dashboard')]")
    public WebElement dashBoard;

    @FindBy(linkText = "Accounts")
    public WebElement accountLink;

    @FindBy(className = "css-5605sr")
    public WebElement accountTable;

    @FindBy(xpath = "//select[@class='chakra-select css-161pkch']")
    public WebElement accountRecordsIndicator;

 }
