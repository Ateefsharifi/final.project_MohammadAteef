package Tests;
import Base.TekInsurance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class AccountTests extends TekInsurance {

    @Test
    public void verifyAccountRecord() throws InterruptedException {
        clickOnElement(homePage.loginBTN);
        sendText(loginPage.UserName,"supervisor");
        sendText(loginPage.password, "tek_supervisor");
        clickOnElement(loginPage.SignInBTN);
        Assert.assertEquals(getElementText(accountsPage.dashBoard),"Dashboard");
        clickOnElement(accountsPage.accountLink);
        accountsRecords(accountsPage.accountTable);
    }

    public void accountsRecords(WebElement element){
        WebElement table = findElement(element);
        List<WebElement> rows=table.findElements(By.tagName("tr"));
        WebElement recordsIndicator=findElement(accountsPage.accountRecordsIndicator);
        Select drpDown=new Select(recordsIndicator);
        WebElement selectedValue=drpDown.getFirstSelectedOption();
        String defaultDrpCount=selectedValue.getText();
        switch (defaultDrpCount){
            case "5":
                Assert.assertEquals("5",defaultDrpCount);
                break;
            case "10":
                Assert.assertEquals("10",defaultDrpCount);
                break;
            case "25":
                Assert.assertEquals("25",defaultDrpCount);
                break;
            case "50":
                Assert.assertEquals("50",defaultDrpCount);
                break;
            default:

        }

    }



}
