package Tests;

import Base.TekInsurance;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TekInsurance {
    @Test
    public void validateHomePage(){

            Assert.assertTrue(isElementDisplay(homePage.createPrimaryAccount),"Create Primary Account");

    }

}
