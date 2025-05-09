package Tests;

import Page.ComparePage;
import Page.HomePage;
import Page.MobilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareTest extends TestBase{
    HomePage homePage;
    MobilePage mobilePage;
    ComparePage comparePage;

    @Test
    public void Verify_CompareProducts()
    {
        homePage=new HomePage(driver);
        homePage.Open_mobilePage();
        String currentWindow= driver.getWindowHandle();
        mobilePage=new MobilePage(driver);
        mobilePage.CompareProducts();
        comparePage=new ComparePage(driver);
        for(String handle: driver.getWindowHandles())
        {
            String title = driver.switchTo().window(handle).getTitle();
            if(title=="Products Comparison List - Magento Commerce")
            {
                driver.manage().window().maximize();
                Assert.assertEquals(comparePage.pageTitle.getText(),"Compare Products");
                Assert.assertEquals(comparePage.sony.getText(),"SONY XPERIA");
                Assert.assertEquals(comparePage.iphone.getText(),"IPHONE");
                comparePage.ClosePopUp_Window();
                break;
            }
        }
        driver.switchTo().window(currentWindow);
        Assert.assertEquals(mobilePage.categoryTitle.getText(),"MOBILE");
    }
}
