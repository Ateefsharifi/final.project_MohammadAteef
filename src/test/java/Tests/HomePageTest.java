package Tests;

import Base.TekInsurance;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TekInsurance {
    @Test
    public void validateHomePage(){

            Assert.assertEquals(getDriver().getTitle(),"Tek Insurance UI");
            Assert.assertTrue(isElementDisplay(homePage.CreatePrimaryAccount),"Create Primary Account");

    }

}
