package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShareWishlistPage extends Page.PageBase {
    public ShareWishlistPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id="email_address")
    WebElement emailInput;
    @FindBy(id="message")
    WebElement msg;
    @FindBy(css="button[title=\"Share Wishlist\"]")
    WebElement shareBtn;

    public void shareWishlist()
    {
        emailInput.sendKeys("maro@mail.com,mar2@mail.com");
        msg.sendKeys("hii");
        shareBtn.click();
    }
}
