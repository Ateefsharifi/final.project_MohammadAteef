package pages;

import Utility.SeleniumUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PlanPage extends SeleniumUtility {
    public PlanPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(className = "css-1wh2kri")
    public WebElement LoginBTN;

    @FindBy( xpath= "//a[normalize-space()='Plans']")
    public WebElement planLink;

    @FindBy(xpath = "//table[@class='chakra-table css-5605sr']")
    public WebElement planTable;

}
