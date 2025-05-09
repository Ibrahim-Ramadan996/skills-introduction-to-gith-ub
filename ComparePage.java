package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{
    public ComparePage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(tagName = "h1")
    public WebElement pageTitle;
    @FindBy(linkText = "SONY XPERIA")
    public WebElement sony;
    @FindBy(linkText = "IPHONE")
    public WebElement iphone;
    @FindBy(css = "button[title=\"Close Window\"]")
    WebElement closeButton;

    public void ClosePopUp_Window()
    {
        closeButton.click();
    }

}
