package Tests;

import Base.TekInsurance;
import com.google.common.collect.Table;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class PlanPageTest extends TekInsurance {


    @Test
    public void UserProfileDataValidation() throws InterruptedException {
        LoginWithValidCredential("supervisor","tek_supervisor");
        clickOnElement(planPage.PlanBTN);
        getPlanData();
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

    public void getPlanData(){
        List<WebElement> PlanTableRow=findElement(planPage.PlanDataElements);
        for(WebElement element:PlanTableRow){
            System.out.println();
        }




    }



}
