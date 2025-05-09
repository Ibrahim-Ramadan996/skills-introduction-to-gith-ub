package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageBase{
    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(linkText ="MOBILE")
    WebElement mobile;

    @FindBy(className = "page-title")
    public WebElement title;
    @FindBy(linkText = "ACCOUNT")
    WebElement accountList;
    @FindBy(css = "a[title=\"My Account\"]")
    WebElement myAccount;
    public void Open_mobilePage()
    {
        mobile.click();
    }
    public void Open_login_CreateAccPage()
    {
        accountList.click();
        myAccount.click();
    }
}
