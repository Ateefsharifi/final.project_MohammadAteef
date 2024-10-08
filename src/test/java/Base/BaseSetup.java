package Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseSetup {
    private static final Logger LOGGER= LogManager.getLogger(BaseSetup.class);
    protected static final long WAIT_TIME_IN_SECOND=20;

    private static WebDriver driver;
    private final Properties properties;

    public BaseSetup() {
        String configFilePath=System.getProperty("user.dir")+"/src/test/resources/configs/dev-config.properties";
        try{
            LOGGER.debug("Reading config file from path {}",configFilePath);
            InputStream inputStream=new FileInputStream(configFilePath);
            properties=new Properties();
            properties.load(inputStream);

        }catch (IOException ioException){
            LOGGER.error("config file error and its message{}",ioException.getMessage());
            throw new RuntimeException("config file error and its message{}"+ioException.getMessage());

        }

    }
    public void setUpBrowser(){
        String url=properties.getProperty("ui.url");
        String browserType=properties.getProperty("ui.browser");
        boolean isHeadless=Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info("Opening on {} Browser",browserType);
        LOGGER.info("Is headless{}",isHeadless);
        switch (browserType.toLowerCase()){
            case "chrome":
                ChromeOptions chromeOptions=new ChromeOptions();
                if (isHeadless)chromeOptions.addArguments("--headless");
                driver=new ChromeDriver();
                break;
            case "firefox":
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                if (isHeadless)firefoxOptions.addArguments("--headless");
                driver=new FirefoxDriver();
                break;
            case "edge":
                EdgeOptions edgeOptions=new EdgeOptions();
                if (isHeadless)edgeOptions.addArguments("--headless");
                driver=new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser is Wrong, Please select from Chrome,FirFox,Edge");


        }
        LOGGER.info("Navigate to URL{}",url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME_IN_SECOND));


    }
    public void quiteBrowser(){
       if (driver!=null){
           LOGGER.info("Browser quite");
           driver.quit();
       }
    }
    public WebDriver getDriver(){
        return driver;
    }
}
