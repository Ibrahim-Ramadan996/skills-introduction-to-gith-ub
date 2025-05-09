package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="billing:street1")
    WebElement address;

    @FindBy(id = "billing:city")
    WebElement city;

    @FindBy(id="billing:region_id")
    WebElement stateList;

    @FindBy(id = "billing:postcode")
    WebElement zipcode;

    @FindBy(id="billing:country_id")
    WebElement countryList;

    @FindBy(id = "billing:telephone")
    WebElement phone;

    @FindBy(css = "button[title=\"Continue\"]")
    WebElement contiBtn;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/ol/li[3]/div[2]/form/div[1]/dl/dd/ul/li/label/span")
    public WebElement shipCost;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/ol/li[3]/div[2]/form/div[3]/button")
    public WebElement contiBtn2;

    @FindBy(id = "p_method_check")
    WebElement checkBtn;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/div[2]/button")
    WebElement contiBtn3;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/ol/li[5]/div[2]/div/div[1]/table/tfoot/tr[3]/td[2]/strong/span")
    public WebElement totalCost;

    @FindBy(css = "button[title=\"Place Order\"]")
    public WebElement orderBtn;

    @FindBy(id = "billing-address-select")
    public WebElement billingList;

    public void SetCheckout(String addr,String city_,String code,String phone_,String state,String country) {
        address.clear();
        address.sendKeys(addr);
        city.clear();
        city.sendKeys(city_);
        select = new Select(stateList);
        select.selectByVisibleText(state);
        zipcode.clear();
        zipcode.sendKeys(code);
        select = new Select(countryList);
        select.selectByVisibleText(country);
        phone.clear();
        phone.sendKeys(phone_);
        contiBtn.click();
    }

    public void setCheckout2() {
        contiBtn2.click();
        checkBtn.click();
        contiBtn3.click();
    }

    public void SetOrder() {

        orderBtn.click();
    }

    public void SelectBillingInfo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("billing-address-select")));
        select = new Select(billingList);
        select.selectByIndex(1);
    }
}
