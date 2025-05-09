package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(id="email")
    WebElement mail;
    @FindBy(id="pass")
    WebElement pass;
    @FindBy(id="send2")
    WebElement logBtn;
    @FindBy(css = "a[title=\"Create an Account\"]")
    WebElement createAccButton;

    public void LogIn(String email,String password)
    {
        mail.sendKeys(email);
        pass.sendKeys(password);
        logBtn.click();
    }
    public void Open_CreateAccPage()
    {
        createAccButton.click();
    }
}
