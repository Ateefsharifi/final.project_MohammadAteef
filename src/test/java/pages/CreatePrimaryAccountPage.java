package pages;

import Utility.SeleniumUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;


public class CreatePrimaryAccountPage extends SeleniumUtility {
    public CreatePrimaryAccountPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(className = "css-1pqwvz2")
    public WebElement createAccountHolder;

    @FindBy(className = "css-1jb3vzl")
    public WebElement accountHolderTitle;

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
    public WebElement createAccountBtn;

    @FindBy(className = "css-tidvy5")
    public WebElement createAccountExistError;

    @FindBy(xpath = "//*/div/div[2]/div/div/div/form/div[1]/div")
    public WebElement ageErrorMessage;

    public void fillCreateAccountForm(String Email,String firstName,int gender,String employmentStatus,int title,String lastName,int martialStatus,String dateOfBirth) {
        sendText(this.email, Email);
        sendText(this.firstName, firstName);
        dropDownByValue(this.gender,gender);
        sendText(this.employmentStatus,employmentStatus);
        dropDownByValue(this.title,title);
        sendText(this.lastName, lastName);
        dropDownByValue(this.maritalStatus,martialStatus);
        sendText(this.dateOfBirth,dateOfBirth);
        clickOnElement(this.createAccountBtn);
    }

}
