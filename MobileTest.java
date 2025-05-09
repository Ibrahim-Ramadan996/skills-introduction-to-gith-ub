package Tests;

import Page.HomePage;
import Page.MobilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTest extends TestBase{
    HomePage homePage;
    MobilePage mobilePage;

    @Test
    public void VerifySort_MobileList()
    {
        String previous="";
        homePage=new HomePage(driver);
        Assert.assertEquals(driver.getTitle(),"Home page");
        Assert.assertTrue(homePage.title.getText().toLowerCase().contains("this is demo site"));
        homePage.Open_mobilePage();
        Assert.assertEquals(driver.getTitle(),"Mobile");
        mobilePage=new MobilePage(driver);
        Assert.assertEquals(mobilePage.categoryTitle.getText(),"MOBILE");
        mobilePage.testSort();
        for(String name: mobilePage.productNames)
        {
            Assert.assertTrue(name.compareTo(previous) > 0);
            previous=name;
        }
    }
}
