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

    @FindBy(xpath = "//*/div/div[2]/div/div/div/h2[3]")
    public WebElement SignUpValidateEmail;

    @FindBy(name = "username")
    public WebElement CreatedAccountSignUpUsername;

    @FindBy(name = "password")
    public WebElement CreatedAccountSignUpPassword;

    @FindBy(name = "confirm")
    public WebElement CreatedConfirmAccountSignUpConfirmPassword;

    @FindBy(className = "css-jut409")
    public WebElement CreatedAccountValidateSubmitBtn;

    public void EnterUserName(String username){
        sendText(CreatedAccountSignUpUsername,username);
    }

    public void EnterPassword(String password){
        sendText(CreatedAccountSignUpPassword,password);
    }

    public void EnterConfirmPassword(String confirmPassword){
        sendText(CreatedConfirmAccountSignUpConfirmPassword,confirmPassword);
    }
    public void ClickSubmitButton(){
        clickOnElement(CreatedAccountValidateSubmitBtn);
    }

}
