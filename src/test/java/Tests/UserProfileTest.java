package Tests;
import Base.TekInsurance;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTest extends TekInsurance {
    private static final String LoginUserName="supervisor";
    private static final String LoginPassword="tek_supervisor";

    @Test
    public void ValidateUserProfile(){
        LoginWithValidCredential(LoginUserName,LoginPassword);

        Assert.assertTrue(userProfile.CustomerServicePortal.isDisplayed());
        clickOnElement(userProfile.Profile);
        Assert.assertEquals(LoginUserName,getElementText(userProfile.SideMenuUserName));
        clickOnElement(userProfile.SideMenuProfileClose);


    }

    @Test
    public void LoggingInWithValidCredentialAndLogOUt(){
        LoginWithValidCredentialAndLogout(LoginUserName,LoginPassword);

        Assert.assertEquals(getDriver().getTitle(),"Tek Insurance UI");
    }

    public void LoginWithValidCredential(String UserName,String Password){
        Assert.assertTrue(homePage.loginBTN.isEnabled());
        clickOnElement(homePage.loginBTN);
        Assert.assertEquals(getElementText(loginPage.SignInText),"Sign in to your Account");
        sendText(loginPage.UserName,UserName);
        sendText(loginPage.password, Password);
        clickOnElement(loginPage.SignInBTN);

    }

    public void LoginWithValidCredentialAndLogout(String UserName,String Password){
        Assert.assertTrue(homePage.loginBTN.isEnabled());
        clickOnElement(homePage.loginBTN);
        Assert.assertEquals(getElementText(loginPage.SignInText),"Sign in to your Account");
        sendText(loginPage.UserName,UserName);
        sendText(loginPage.password, Password);
        clickOnElement(loginPage.SignInBTN);
        Assert.assertTrue(userProfile.CustomerServicePortal.isDisplayed());
        clickOnElement(userProfile.Profile);
        Assert.assertEquals(LoginUserName,getElementText(userProfile.SideMenuUserName));
        clickOnElement(userProfile.UserProfileLogOut);
    }
}
