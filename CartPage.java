package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import java.time.Duration;

public class CartPage extends PageBase{
    public CartPage(WebDriver driver)
    {
        super(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @FindBy(css = "input[title=\"Qty\"]")
    WebElement qtyInput;
    @FindBy(css = "button.button.btn-update")
    WebElement updateButton;
    @FindBy(className = "error-msg")
    public WebElement errorMessage;
    @FindBy(id = "empty_cart_button")
    public WebElement emptyButton;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div/div[2]/p[1]")
    public WebElement emptyMessage;
    @FindBy(css = "button[title=\"Proceed to Checkout\"]")
    WebElement proceedToCheckoutButton;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span")
    public WebElement grandTotal;
    @FindBy(id = "coupon_code")
    WebElement couponCodeInput;
    @FindBy(css = "button[title=\"Apply\"]")
    WebElement applyCouponButton;
    @FindBy(css = "td.product-name a")
    public WebElement productNameInCart;




    public void setQuantity(String input)
    {
        wait.until(ExpectedConditions.visibilityOf(qtyInput));
        qtyInput.clear();
        qtyInput.sendKeys(input);
        updateButton.click();
    }

    public void EmptyCart()
    {
        wait.until(ExpectedConditions.elementToBeClickable(emptyButton)).click();
    }
    public void ProceedToCheckout()
    {
        proceedToCheckoutButton.click();
    }
    public void enterCouponCode(String input)
    {
        wait.until(ExpectedConditions.visibilityOf(couponCodeInput));
        couponCodeInput.clear();
        couponCodeInput.sendKeys(input);
        applyCouponButton.click();
    }


}
