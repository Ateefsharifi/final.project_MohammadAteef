package Tests;

import Base.TekInsurance;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends TekInsurance {

    @Test(dataProvider = "loginValue")
    public void navigateToLoginByValidCredential(String UserName,String Password){
        Assert.assertTrue(homePage.loginBTN.isEnabled());
        clickOnElement(homePage.loginBTN);
        Assert.assertEquals(getElementText(loginPage.SignInText),"Sign in to your Account");
        sendText(loginPage.UserName,UserName);
        sendText(loginPage.password, Password);
        clickOnElement(loginPage.SignInBTN);

    }
    @Test(dataProvider = "loginValue")
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

    @DataProvider(name = "loginValue")
    public String[][] Credential(){
       return new String[][] {
               {"supervisor","tek_supervisor"},
        };
    }


}
