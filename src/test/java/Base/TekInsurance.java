package Base;
import Utility.SeleniumUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TekInsurance extends SeleniumUtility {
    private static final Logger LOGGER=LogManager.getLogger(TekInsurance.class);


    @BeforeMethod
    public void setUpTest(){
        LOGGER.info("Setting up Test and lunching Browser");
        setUpBrowser();

    }
    @AfterMethod
    public void testCleanUp(){
        LOGGER.info("Browser Quite");
        quiteBrowser();
    }

}
