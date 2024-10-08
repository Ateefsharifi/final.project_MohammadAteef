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
        sendText(loginPage.userName,"supervisor");
        sendText(loginPage.password, "tek_supervisor");
        clickOnElement(loginPage.signInBTN);
        Assert.assertEquals(getElementText(accountsPage.dashBoard),"Dashboard");
        clickOnElement(accountsPage.accountLink);
        WebElement table = findElement(accountsPage.accountTable);
        List<WebElement> rows=table.findElements(By.tagName("tr"));
        WebElement recordsIndicator=findElement(accountsPage.accountRecordsIndicator);
        Select drpDown=new Select(recordsIndicator);
        WebElement selectedValue=drpDown.getFirstSelectedOption();
        Assert.assertEquals(rows.size()-1,5);
        Assert.assertEquals(getElementText(selectedValue),"Show 5");
    }

    @Test
    public void verifyAccountRecordsOnDrpValue() throws InterruptedException {
        clickOnElement(homePage.loginBTN);
        sendText(loginPage.userName,"supervisor");
        sendText(loginPage.password, "tek_supervisor");
        clickOnElement(loginPage.signInBTN);
        Assert.assertEquals(getElementText(accountsPage.dashBoard),"Dashboard");
        clickOnElement(accountsPage.accountLink);
        WebElement recordsIndicator=findElement(accountsPage.accountRecordsIndicator);
        Select drpDown=new Select(recordsIndicator);
        drpDown.selectByValue("10");
        Thread.sleep(2000);
        int drpSize=drpDown.getOptions().size();
        WebElement table = findElement(accountsPage.accountTable);
        List<WebElement> rows=table.findElements(By.tagName("tr"));
        Assert.assertEquals(rows.size()-1,10);
    }

}
