package Tests;
import Base.TekInsurance;
import Common.RandomValueClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePrimaryAccountPageTest extends TekInsurance {
    public static String ValidEmail;
    RandomValueClass objRandomValue=new RandomValueClass();

    @Test(testName = "CreatingAccountWithValidEmail")
    public void createAccountWithValidEmail(){
        clickOnElement(homePage.CreatePrimaryAccount);
        Assert.assertTrue(isElementDisplay(createPrimaryAccountPage.CreateAccountHolder), "primary Account Creation");
        ValidEmail=objRandomValue.generateRandomEmail();
        fillCreateAccountForm(ValidEmail);
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

    @Test(testName = "validate DateOfBirth through creating valid Account")
    public void validateDOBInCreatingAccount(){
        clickOnElement(homePage.CreatePrimaryAccount);
        Assert.assertTrue(isElementDisplay(createPrimaryAccountPage.CreateAccountHolder), "primary Account Creation");
        ValidEmail=objRandomValue.generateRandomEmail();

        try{

            fillCreateAccountForm(ValidEmail);
            Assert.assertEquals(getElementText(createPrimaryAccountPage.ageErrorMessage),"you must be 18 years or older to create account");


        }catch(Exception exception){
            System.out.println(exception.toString());
        }

    }

    public void fillCreateAccountForm(String Email) {
        sendText(createPrimaryAccountPage.email,ValidEmail);
        sendText(createPrimaryAccountPage.firstName,objRandomValue.generateName());
        dropDownByValue(createPrimaryAccountPage.gender,2);
        sendText(createPrimaryAccountPage.employmentStatus,"Self Employed");
        dropDownByValue(createPrimaryAccountPage.title,2);
        sendText(createPrimaryAccountPage.lastName,objRandomValue.generateName());
        dropDownByValue(createPrimaryAccountPage.maritalStatus, 2);
        sendText(createPrimaryAccountPage.dateOfBirth,objRandomValue.generateDate());
        clickOnElement(createPrimaryAccountPage.CreateAccountBtn);

    }

    public  void creatingAccountSignUp() throws InterruptedException {

        Thread.sleep(2000);
        Assert.assertTrue(isElementDisplay(signUpPage.SignUpValidateEmail));

        clearWebElement(signUpPage.CreatedAccountSignUpUsername);
        clearWebElement(signUpPage.CreatedAccountSignUpPassword);

        sendText(signUpPage.CreatedAccountSignUpUsername,ValidEmail);
        sendText(signUpPage.CreatedAccountSignUpPassword,"Test@12345");
        sendText(signUpPage.CreatedConfirmAccountSignUpConfirmPassword,"Test@12345");
        clickOnElement(signUpPage.CreatedAccountValidateSubmitBtn);
    }

    public void clearWebElement(WebElement element){
        element.clear();
    }


}
