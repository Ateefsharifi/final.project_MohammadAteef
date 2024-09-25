package pages;

import Utility.SeleniumUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanPage extends SeleniumUtility {
    public PlanPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(className = "css-1wh2kri")
    public WebElement LoginBTN;

    @FindBy(xpath = "//*/div/div[2]/div/div/a[2]")
    public WebElement PlanBTN;

    @FindBy(xpath = "//*/div/div[3]/div/div/div/div/table")
    public WebElement PlanTable;

    @FindBy(xpath = "//*/div/div[3]/div/div/div/div/table/tbody/tr")
    public WebElement tableRow;

    @FindBy(xpath = "//*/div/div[3]/div/div/div/div/table/tbody/tr/td")
    public WebElement tableCol;
}
