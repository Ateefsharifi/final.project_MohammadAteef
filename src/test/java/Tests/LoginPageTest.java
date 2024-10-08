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
        Assert.assertEquals(getElementText(loginPage.signInText),"Sign in to your Account");
        sendText(loginPage.userName,UserName);
        sendText(loginPage.password, Password);
        clickOnElement(loginPage.signInBTN);

    }
    @Test(testName = "navigateToLoginByInvalidCredential", dataProvider = "invalidCredential")
    public void navigateToLoginByInvalidCredential(String userName,String password){
        Assert.assertTrue(homePage.loginBTN.isEnabled());
        clickOnElement(homePage.loginBTN);
        Assert.assertEquals(getElementText(loginPage.signInText),"Sign in to your Account");
        sendText(loginPage.userName,userName);
        sendText(loginPage.password, password);
        clickOnElement(loginPage.signInBTN);
        if(loginPage.invalidLoginError.isDisplayed()){
            Assert.assertTrue(loginPage.invalidLoginError.isDisplayed(),"credential is invalid");
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
