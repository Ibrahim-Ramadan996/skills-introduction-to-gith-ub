package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends Page.PageBase {
    public WishlistPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(name = "save_and_share")
    WebElement shareWishBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li")
    public WebElement sucMsg;
    @FindBy(css = "button[title=\"Add to Cart\"]")
    WebElement addCart;
    public void Open_ShareWishlistPage()
    {
        shareWishBtn.click();
    }
    public void AddToCart()
    {
        addCart.click();
    }

}
