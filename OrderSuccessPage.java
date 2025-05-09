package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import java.util.concurrent.TimeUnit;

public class OrderSuccessPage extends PageBase{
    public OrderSuccessPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(className = "page-title")
    public WebElement title;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div/p[1]")
    public WebElement msg;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div/p[1]/a")
    public WebElement orderNum;
}
