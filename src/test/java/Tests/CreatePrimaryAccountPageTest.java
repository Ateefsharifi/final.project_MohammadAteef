package Tests;
import Base.TekInsurance;
import Common.RandomValueClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePrimaryAccountPageTest extends TekInsurance {
    public static String validEmail;
    RandomValueClass objRandomValue = new RandomValueClass();

    @Test(testName = "CreatingAccountWithValidEmail")
    public void createAccountWithValidEmail() {
        clickOnElement(homePage.createPrimaryAccount);
        Assert.assertTrue(isElementDisplay(createPrimaryAccountPage.createAccountHolder), "primary Account Creation");
        String validEmail= objRandomValue.generateRandomEmail();
        createPrimaryAccountPage.fillCreateAccountForm(validEmail,objRandomValue.generateName(),2,"self emplyed,",2,"Ahmad",2, objRandomValue.generateDate());
        clickOnElement(createPrimaryAccountPage.createAccountBtn);
        Assert.assertEquals(getElementText(signUpPage.SignUpValidateEmail),validEmail);
    }

    @Test(testName = "createAccountWithExistingEmail")
    public void createAccountWithExistingEmail() {
        clickOnElement(homePage.createPrimaryAccount);
        Assert.assertTrue(isElementDisplay(createPrimaryAccountPage.createAccountHolder), "primary Account Creation");
        createPrimaryAccountPage.fillCreateAccountForm("Example@gmail.com", objRandomValue.generateName(),2,"self employed,",2,"Ahmad",2, objRandomValue.generateDate());
        clickOnElement(createPrimaryAccountPage.createAccountBtn);
        Assert.assertTrue(isElementDisplay(createPrimaryAccountPage.createAccountExistError));
    }




}
