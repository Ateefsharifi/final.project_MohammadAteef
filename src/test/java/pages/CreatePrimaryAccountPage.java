package pages;

import Utility.SeleniumUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreatePrimaryAccountPage extends SeleniumUtility {
    public CreatePrimaryAccountPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(className = "css-1pqwvz2")
    public WebElement CreateAccountHolder;

    @FindBy(className = "css-1jb3vzl")
    public WebElement AccountHolderTitle;

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(name = "firstName")
    public WebElement firstName;

    @FindBy(id = "gender")
    public WebElement gender;

    @FindBy(name = "employmentStatus")
    public WebElement employmentStatus;

    @FindBy(id = "title")
    public WebElement title;

    @FindBy(name = "lastName")
    public WebElement lastName;

    @FindBy(id = "maritalStatus")
    public WebElement maritalStatus;

    @FindBy(name = "dateOfBirth")
    public WebElement dateOfBirth;

    @FindBy(className = "css-jut409")
    public WebElement CreateAccountBtn;

    @FindBy(className = "css-tidvy5")
    public WebElement CreateAccountExistError;





}
