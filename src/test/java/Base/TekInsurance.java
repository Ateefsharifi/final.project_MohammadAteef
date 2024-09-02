package Base;
import Tests.*;
import Utility.SeleniumUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import pages.*;

public class
TekInsurance extends SeleniumUtility {
    private static final Logger LOGGER=LogManager.getLogger(TekInsurance.class);
    public HomePage homePage;
    public HomePageTest homePageTest;
    public CreatePrimaryAccountPage createPrimaryAccountPage;
    public CreatePrimaryAccountPageTest createPrimaryAccountPageTest;
    public SignUpPage signUpPage;
    public SignUpTest signUpTest;
    public LoginPage loginPage;
    public LoginPageTest loginPageTest;
    public UserProfile userProfile;
    public UserProfileTest userProfileTest;


    @BeforeSuite
    public void setUpTest(){
        LOGGER.info("Setting up Test and lunching Browser");
        setUpBrowser();
        homePage=new HomePage();
        homePageTest=new HomePageTest();
        createPrimaryAccountPage=new CreatePrimaryAccountPage();
        createPrimaryAccountPageTest=new CreatePrimaryAccountPageTest();
        signUpPage=new SignUpPage();
        signUpTest=new SignUpTest();
        loginPage=new LoginPage();
        loginPageTest=new LoginPageTest();
        userProfile=new UserProfile();
        userProfileTest=new UserProfileTest();

    }
    @AfterSuite
    public void testCleanUp(){
        LOGGER.info("Browser Quite");
        quiteBrowser();
    }

}
