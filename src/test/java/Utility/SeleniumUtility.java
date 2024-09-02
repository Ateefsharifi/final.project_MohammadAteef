package Utility;

import Base.BaseSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumUtility extends BaseSetup {
    private static final Logger LOGGER= LogManager.getLogger(SeleniumUtility.class);

    private WebDriverWait getWait(){
        return new  WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIME_IN_SECOND));
    }

    public String getElementText(WebElement element){
       LOGGER.debug("Returning Element Text{}",element);
       return getWait().until(ExpectedConditions.visibilityOf(element)).getText();

    }

    public void clickOnElement(WebElement element){
        LOGGER.debug("clickable element{}",element);
       getWait().until(ExpectedConditions.elementToBeClickable(element)).click();

    }
    public boolean isElementDisplay(WebElement element){
        LOGGER.debug("returning condition{}",element);
        return getWait().until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
    public void sendText(WebElement element,String value){
        LOGGER.debug("sending text to element{}",element);
        getWait().until(ExpectedConditions.visibilityOf(element)).sendKeys(value);

    }
    public void dropDownByValue(WebElement element,int index){
        LOGGER.debug("selecting value from dropdown{}",element);
       Select selectDropDown=new Select(getWait().until(ExpectedConditions.visibilityOf(element)));
        //List<WebElement> option=selectDropDown.getOptions();
        selectDropDown.selectByIndex(index);

    }



}
