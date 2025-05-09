package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page.PageBase {
    public AccountPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(className = "page-title")
    public WebElement title;
    @FindBy(className = "success-msg")
    public WebElement sucMsg;
    @FindBy(linkText = "TV")
    WebElement tv;
    @FindBy(linkText="MY WISHLIST")

    WebElement wishList;
    @FindBy(linkText = "MY ORDERS")
    WebElement myOrders;
    @FindBy(linkText = "REORDER")
    WebElement reorder;
    @FindBy(linkText = "MOBILE")
    WebElement mobile;
    public void Open_TvPage()
    {
        tv.click();
    }
    public void Open_WishListPage()
    {
        wishList.click();
    }
    public void Open_OrdersPage()
    {
        myOrders.click();
    }
    public void ReorderProduct()
    {
        reorder.click();
    }
    public void Open_MobilePage()
    {
        mobile.click();
    }

}
