package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends PageBase{
    public CreateAccountPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(id="firstname")
    WebElement fName;
    @FindBy(id="middlename")
    WebElement midName;
    @FindBy(id="lastname")
    WebElement lName;
    @FindBy(id="email_address")
    WebElement email;
    @FindBy(id="password")
    WebElement pass;
    @FindBy(id="confirmation")
    WebElement coPass;
    @FindBy(css = "button[title=\"Register\"]")
    WebElement regButton;

    public void CreateAccount(String fname,String mname,String lname,String mail,String password,String conf_password)
    {
        fName.sendKeys(fname);
        midName.sendKeys(mname);
        lName.sendKeys(lname);
        email.sendKeys(mail);
        pass.sendKeys(password);
        coPass.sendKeys(conf_password);
        regButton.click();
    }
}
