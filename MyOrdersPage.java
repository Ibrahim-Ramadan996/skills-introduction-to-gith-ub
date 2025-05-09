package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyOrdersPage extends PageBase{
    public MyOrdersPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(css = "tr.first.last.odd")
    WebElement firstRow;
    public List<WebElement> cells=firstRow.findElements(By.tagName("td"));
    @FindBy(linkText = "VIEW ORDER")
    WebElement viewOrder;
    @FindBy(className = "link-print")
    WebElement print;
    public void ViewOrder()
    {
        viewOrder.click();
    }
    public void PrintOrder()
    {
        print.click();
    }

}
