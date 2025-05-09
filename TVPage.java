package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TVPage extends Page.PageBase {
    public TVPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")
    WebElement wishLG;

    public void AddWishlist()
    {
        wishLG.click();
    }
}
