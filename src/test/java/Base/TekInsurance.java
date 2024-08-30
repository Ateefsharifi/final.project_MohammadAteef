package Base;
import Tests.CreatePrimaryAccountPageTest;
import Tests.SignUpTest;
import Utility.SeleniumUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import Tests.HomePageTest;
import pages.CreatePrimaryAccountPage;
import pages.HomePage;
import pages.SignUpPage;

public class
TekInsurance extends SeleniumUtility {
    private static final Logger LOGGER=LogManager.getLogger(TekInsurance.class);
    public HomePage homePage;
    public HomePageTest homePageTest;
    public CreatePrimaryAccountPage createPrimaryAccountPage;
    public CreatePrimaryAccountPageTest createPrimaryAccountPageTest;
    public SignUpPage signUpPage;
    public SignUpTest signUpTest;


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

    }
    @AfterSuite
    public void testCleanUp(){
        LOGGER.info("Browser Quite");
        quiteBrowser();
    }

}
