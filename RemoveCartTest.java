package Tests;

import Page.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveCartTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    MobilePage mobilePage;
    CartPage cartPage;

    @Test
    public void removeAllItemsFromCart() {
        homePage = new HomePage(driver);
        homePage.Open_login_CreateAccPage();

        loginPage = new LoginPage(driver);
        loginPage.LogIn("medo111@gmail.com", "123456");

        accountPage = new AccountPage(driver);
        accountPage.Open_MobilePage();

        mobilePage = new MobilePage(driver);
        mobilePage.addToCart_Sony();
        mobilePage.addToCart_Iphone();

        cartPage = new CartPage(driver);
        cartPage.EmptyCart();

        Assert.assertTrue(cartPage.emptyMessage.getText().contains("You have no items in your shopping cart."));
    }

}
