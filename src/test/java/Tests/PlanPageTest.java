package Tests;

import Base.TekInsurance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PlanPage;

import java.util.List;


public class PlanPageTest extends TekInsurance {


    @Test
    public void UserProfileDataValidation() throws InterruptedException {
        LoginWithValidCredential("supervisor","tek_supervisor");
        clickOnElement(planPage.PlanBTN);
        Thread.sleep(2000);
        ValidatePlanData();
        Thread.sleep(2000);


    }

    public void LoginWithValidCredential(String UserName,String Password){
        Assert.assertTrue(planPage.LoginBTN.isEnabled());
        clickOnElement(planPage.LoginBTN);
        Assert.assertEquals(getElementText(loginPage.SignInText),"Sign in to your Account");
        sendText(loginPage.UserName,UserName);
        sendText(loginPage.password, Password);
        clickOnElement(loginPage.SignInBTN);
    }
    public void ValidatePlanData(){
      //  WebElement Table=findElement(planPage.PlanTable);
       // List<WebElement> rowDataElements=Table.findElements(planPage.tableRow);
       // int rowSize=rowDataElements.size();
       // for(int i=1; i<rowSize;i++){
      //      List<WebElement> colData=rowDataElements.get(i).findElements(By.xpath("//*/div/div[3]/div/div/div/div/table/tbody/tr/td"));
        //    int colSize=colData.size();
       //     for(int j=1; j<colSize; j++){
        //        WebElement element=colData.get(j);
        //        System.out.print(element.getText());
         //   }
      //  }
    }



}
