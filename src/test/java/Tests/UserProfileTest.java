package Tests;
import Base.TekInsurance;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTest extends TekInsurance {
    private static final String loginUserName="supervisor";
    private static final String loginPassword="tek_supervisor";

    @Test
    public void ValidateUserProfile(){
        loginWithValidCredential(loginUserName,loginPassword);
        Assert.assertTrue(userProfile.customerServicePortal.isDisplayed());
        clickOnElement(userProfile.profile);
        Assert.assertEquals(loginUserName,getElementText(userProfile.sideMenuUserName));
        clickOnElement(userProfile.sideMenuProfileClose);
    }

    @Test
    public void loggingInWithValidCredentialAndLogOUt(){
        LoginWithValidCredentialAndLogout(loginUserName, loginPassword);
       // Assert.assertEquals(getDriver().getTitle(),"Tek Insurance UI");
    }

    public void loginWithValidCredential(String userName,String password){
        Assert.assertTrue(homePage.loginBTN.isEnabled());
        clickOnElement(homePage.loginBTN);
        Assert.assertEquals(getElementText(loginPage.signInText),"Sign in to your Account");
        sendText(loginPage.userName,userName);
        sendText(loginPage.password, password);
        clickOnElement(loginPage.signInBTN);

    }
    public void LoginWithValidCredentialAndLogout(String userName,String password){
        loginWithValidCredential(userName,password);
        Assert.assertTrue(userProfile.customerServicePortal.isDisplayed());
        clickOnElement(userProfile.profile);
        Assert.assertEquals(loginUserName,getElementText(userProfile.sideMenuUserName));
        clickOnElement(userProfile.userProfileLogOutBtn);
    }
}
