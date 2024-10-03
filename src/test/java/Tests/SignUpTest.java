package Tests;
import Base.TekInsurance;
import Common.RandomValueClass;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SignUpTest extends TekInsurance {

    @Test
    public void creatingAccountSignUp() {
        clickOnElement(homePage.createPrimaryAccount);
        RandomValueClass objRandom=new RandomValueClass();
        String email = objRandom.generateRandomEmail();
        createPrimaryAccountPage.fillCreateAccountForm(email,objRandom.generateName(),2,
                "self employed,",2,"Ahmad",2, "01/01/1990");
        signUpPage.createdAccountSignUpUsername.clear();
        signUpPage.createdAccountSignUpPassword.clear();
        String expectedEmail=getElementText(signUpPage.SignUpValidateEmail);
        Assert.assertEquals(email,expectedEmail);
        sendText(signUpPage.createdAccountSignUpUsername, expectedEmail);
        sendText(signUpPage.createdAccountSignUpPassword, "Test@12345");
        sendText(signUpPage.createdConfirmAccountSignUpConfirmPassword, "Test@12345");
        clickOnElement(signUpPage.createdAccountValidateSubmitBtn);
    }
}
