package pages;

import Base.TekInsurance;
import Utility.SeleniumUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends SeleniumUtility {

    public SignUpPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//*/div/div[2]/div/div/div/h2[1]")
    public WebElement signUpValidationPage;

    @FindBy(xpath = "//*/div/div[2]/div/div/div/h2[3]")
    public WebElement SignUpValidateEmail;

    @FindBy(name = "username")
    public WebElement createdAccountSignUpUsername;

    @FindBy(name = "password")
    public WebElement createdAccountSignUpPassword;

    @FindBy(name = "confirm")
    public WebElement createdConfirmAccountSignUpConfirmPassword;

    @FindBy(className = "css-jut409")
    public WebElement createdAccountValidateSubmitBtn;

    public void EnterUserName(String username){
        sendText(createdAccountSignUpUsername,username);
    }

    public void EnterPassword(String password){
        sendText(createdAccountSignUpPassword,password);
    }

    public void EnterConfirmPassword(String confirmPassword){
        sendText(createdConfirmAccountSignUpConfirmPassword,confirmPassword);
    }
    public void ClickSubmitButton(){
        clickOnElement(createdAccountValidateSubmitBtn);
    }

}
