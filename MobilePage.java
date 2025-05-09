package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MobilePage extends PageBase {
    public MobilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    public WebElement categoryTitle;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")
    WebElement selectList;
    //By.cssSelector("select[title=\"Sort By\"]")
    @FindBy(css = "ul.products-grid.products-grid--max-4-col.first.last.odd")
    WebElement products;
    public List<String> productNames = new ArrayList<>();
    @FindBy(linkText = "SONY XPERIA")
    WebElement sony;
    //By.id("product-collection-image-1")
    @FindBy(id = "product-price-1")
    public WebElement sonyPrice;
    //By.cssSelector("#product-price-1 > span.price")
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button/span/span")
    WebElement addToCartSony;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/button/span/span")
    WebElement addToCartIphone;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")
    WebElement compareSony;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a")
    WebElement compareIphone;
    @FindBy(css = "button[title=\"Compare\"]")
    WebElement compareButton;
    public void testSort() {
        select = new Select(selectList);
        select.selectByVisibleText("Name");
        List<WebElement> pNames = products.findElements(By.className("product-name"));
        for (WebElement pn : pNames) {
            String s = pn.getText();
            productNames.add(s);
        }
//        /*for(String s:productNames)
//        {
//            System.out.println(s);
//        }*/
    }

    public void open_SonyPage()
    {
        sony.click();
    }
    public void addToCart_Sony()
    {
        addToCartSony.click();
    }
    public void CompareProducts()
    {
        compareSony.click();
        compareIphone.click();
        compareButton.click();
    }
    public void addToCart_Iphone()
    {
        addToCartIphone.click();
    }

}
