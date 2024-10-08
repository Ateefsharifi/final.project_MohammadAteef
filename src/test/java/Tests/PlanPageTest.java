package Tests;
import Base.TekInsurance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PlanPageTest extends TekInsurance {

    @Test(testName = "UserProfileDataValidation")
    public void UserProfileDataValidation(){
        clickOnElement(homePage.loginBTN);
        sendText(loginPage.userName,"supervisor");
        sendText(loginPage.password, "tek_supervisor");
        clickOnElement(loginPage.signInBTN);
        clickOnElement(planPage.planLink);
        planRecordFinding(planPage.planTable);

    }

    public void planRecordFinding(WebElement element){
        WebElement table = findElement(element);
        List<WebElement> rows=table.findElements(By.tagName("tr"));
        for(int r=1; r<4; r++){
            WebElement row=rows.get(r);
            List<WebElement> cols=row.findElements(By.tagName("td"));
            for(int c=0; c<4; c++){
                WebElement dateCreatedCol=cols.get(3);
                WebElement dateExpiredCol=cols.get(4);
                LocalDate todayDate = LocalDate.now();
                LocalDate tomorrowDate = todayDate.plusDays(1);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                String todayFormattedDate = todayDate.format(formatter);
                String tomorrowFormattedDate = tomorrowDate.format(formatter);
                Assert.assertEquals(getElementText(dateCreatedCol),todayFormattedDate);
                Assert.assertEquals(getElementText(dateExpiredCol),tomorrowFormattedDate);
            }

        }

    }

}
