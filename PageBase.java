package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageBase {
        public WebDriver driver;
        public Select select;
        public Actions act;
        public WebDriverWait wait;

        public PageBase(WebDriver driver) {
                this.driver = driver;
                PageFactory.initElements(driver, this);
                act = new Actions(driver);
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
}
