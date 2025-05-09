package Tests;

import Page.HomePage;
import Page.MobilePage;
import Page.SonyPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SonyTest extends TestBase{
    HomePage homePage;
    MobilePage mobilePage;
    SonyPage sonyPage;
    String sonyP;
    String sonyP2;
    @Test
    public void VerifyCost()
    {
        homePage=new HomePage(driver);
        homePage.Open_mobilePage();
        mobilePage=new MobilePage(driver);
        sonyP=mobilePage.sonyPrice.getText();
        mobilePage.open_SonyPage();
        sonyPage=new SonyPage(driver);
        sonyP2=sonyPage.sonyPrice.getText();
        Assert.assertEquals(sonyP,sonyP2);

    }
}
