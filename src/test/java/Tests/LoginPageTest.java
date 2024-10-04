package Tests;

import Base.TekInsurance;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends TekInsurance {

    @Test(testName = "navigateToLoginByValidCredential", dataProvider = "validCredential")
    public void navigateToLoginByValidCredential(String UserName,String Password){
        Assert.assertTrue(homePage.loginBTN.isEnabled());
        clickOnElement(homePage.loginBTN);
        Assert.assertEquals(getElementText(loginPage.SignInText),"Sign in to your Account");
        sendText(loginPage.UserName,UserName);
        sendText(loginPage.password, Password);
        clickOnElement(loginPage.SignInBTN);

    }
    @Test(testName = "navigateToLoginByInvalidCredential", dataProvider = "invalidCredential")
    public void navigateToLoginByInvalidCredential(String UserName,String Password){
        Assert.assertTrue(homePage.loginBTN.isEnabled());
        clickOnElement(homePage.loginBTN);
        Assert.assertEquals(getElementText(loginPage.SignInText),"Sign in to your Account");
        sendText(loginPage.UserName,UserName);
        sendText(loginPage.password, Password);
        clickOnElement(loginPage.SignInBTN);
        if(loginPage.InvalidLoginError.isDisplayed()){
            Assert.assertTrue(loginPage.InvalidLoginError.isDisplayed(),"credential is invalid");
        }

    }

    @DataProvider(name = "validCredential")
    public String[][] validCredential(){
       return new String[][] {
               {"supervisor","tek_supervisor"},
        };
    }
    @DataProvider(name = "invalidCredential")
    public String[][] invalidCredential(){
        return new String[][] {
                {"tek_supervisor","tek_supervisor"},
        };
    }


}
