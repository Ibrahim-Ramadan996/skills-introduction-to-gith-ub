package Tests;

import Page.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ReorderTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OrderSuccessPage orderSuccessPage;

    @Test
    public void VerifyReorder_Product()
    {
        homePage=new HomePage(driver);
        homePage.Open_login_CreateAccPage();

        loginPage=new LoginPage(driver);
        loginPage.LogIn("medo666666@gmail.com","666666");

        accountPage=new AccountPage(driver);
        accountPage.ReorderProduct();

        cartPage=new CartPage(driver);
        cartPage.setQuantity("10");

        System.out.println("Grand Total = "+cartPage.grandTotal.getText());
        Assert.assertNotSame(cartPage.grandTotal.getText(), "480.00");

        cartPage.ProceedToCheckout();

        checkoutPage=new CheckoutPage(driver);
        checkoutPage.SelectBillingInfo();
        checkoutPage.SetCheckout("123 Main St","New York","10001","2125551234","New York","United States");

        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.contiBtn2));
        checkoutPage.setCheckout2();

        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.orderBtn));


        checkoutPage.SetOrder();
        orderSuccessPage=new OrderSuccessPage(driver);
        System.out.println(" Your order number for your record = "+orderSuccessPage.orderNum.getText());
    }
}
