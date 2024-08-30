package Tests;
import Base.TekInsurance;
import Common.RandomGenerateEmail;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreatePrimaryAccountPageTest extends TekInsurance {
    public static String ActualEmail;
    RandomGenerateEmail objRandomEmail=new RandomGenerateEmail();

    @Test(testName = "CreatingAccountWithValidEmail")
    public void createAccountWithValidEmail() throws InterruptedException {
        clickOnElement(homePage.CreatePrimaryAccount);
        Assert.assertTrue(isElementDisplay(createPrimaryAccountPage.CreateAccountHolder), "primary Account Creation");
        ActualEmail=objRandomEmail.generateRandomEmail();
        fillCreateAccountForm(ActualEmail);
         try {
                 creatingAccountSignUp();

         }catch (Exception exception){
             System.out.println(exception.toString());
         }
    }

    @Test(testName = "createAccountWithExistingEmail")
    public void createAccountWithExistingEmail(){
        clickOnElement(homePage.CreatePrimaryAccount);
        Assert.assertTrue(isElementDisplay(createPrimaryAccountPage.CreateAccountHolder), "primary Account Creation");
        try {
            fillCreateAccountForm("AhmadNawabi51@gmail.com");
            if(createPrimaryAccountPage.CreateAccountExistError.isDisplayed()){
                System.out.println("this email already exist");
            }

        }catch (Exception exception){
            System.out.println(exception.toString());
        }

    }

    public void fillCreateAccountForm(String Email) throws InterruptedException {

        ActualEmail=Email;
        sendText(createPrimaryAccountPage.email,ActualEmail);
        sendText(createPrimaryAccountPage.firstName,"Ahmad");
        dropDownByValue(createPrimaryAccountPage.gender,1);
        sendText(createPrimaryAccountPage.employmentStatus,"Self Employed");
        dropDownByValue(createPrimaryAccountPage.title, 1);
        sendText(createPrimaryAccountPage.lastName,"Nawabi");
        dropDownByValue(createPrimaryAccountPage.maritalStatus,1);
        sendText(createPrimaryAccountPage.dateOfBirth, "03/25/1990");
        clickOnElement(createPrimaryAccountPage.CreateAccountBtn);

    }

    public  void creatingAccountSignUp() throws InterruptedException {

        Thread.sleep(2000);
        Assert.assertTrue(isElementDisplay(signUpPage.SignUpValidateEmail));
        clearWebElement(signUpPage.CreatedAccountSignUpUsername);
        clearWebElement(signUpPage.CreatedAccountSignUpPassword);
        sendText(signUpPage.CreatedAccountSignUpUsername,"AhmadNawabi95@gmail.com");
        sendText(signUpPage.CreatedAccountSignUpPassword,"Test@12345");
        sendText(signUpPage.CreatedConfirmAccountSignUpConfirmPassword,"Test@12345");
        clickOnElement(signUpPage.CreatedAccountValidateSubmitBtn);
    }

    public void clearWebElement(WebElement element){
        element.clear();
    }

}
