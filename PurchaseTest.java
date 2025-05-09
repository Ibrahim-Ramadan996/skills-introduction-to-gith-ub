package Tests;

import Page.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class PurchaseTest extends TestBase{
        HomePage homePage;
        LoginPage loginPage;
        AccountPage accountPage;
        WishlistPage wishlistPage;
        CartPage cartPage;
        CheckoutPage checkoutPage;
        OrderSuccessPage orderSuccessPage;

        @Test
        public void VerifyPurchase_Products()
        {
                homePage=new HomePage(driver);
                homePage.Open_login_CreateAccPage();
                loginPage=new LoginPage(driver);
                loginPage.LogIn("medo111@gmail.com","123456");
                accountPage=new AccountPage(driver);
                accountPage.Open_WishListPage();
                wishlistPage=new WishlistPage(driver);
                wishlistPage.AddToCart();
                cartPage=new CartPage(driver);
                cartPage.ProceedToCheckout();
                checkoutPage=new CheckoutPage(driver);
                try
                {
                        if (checkoutPage.billingList.isDisplayed()) {
                                checkoutPage.SelectBillingInfo();
                        }
                }
                catch (Exception e)
                {
                        System.out.println("No dropdown element present");
                }
                checkoutPage.SetCheckout("123 Main St","New York","10001","2125551234","New York","United States");
                wait=new WebDriverWait(driver, Duration.ofSeconds(20));
                wait.until(ExpectedConditions.visibilityOf(checkoutPage.shipCost));
                Assert.assertEquals(checkoutPage.shipCost.getText(),"$5.00");
                wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.contiBtn2));
                checkoutPage.setCheckout2();
                wait.until(ExpectedConditions.visibilityOf(checkoutPage.totalCost));
                Assert.assertEquals(checkoutPage.totalCost.getText(),"$620.00");
                checkoutPage.SetOrder();
                orderSuccessPage=new OrderSuccessPage(driver);
                Assert.assertTrue(orderSuccessPage.msg.getText().contains("Your order # is:"));
                System.out.println(" Your order number for your record = " + orderSuccessPage.orderNum.getText());
        }
}
