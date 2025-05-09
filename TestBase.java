package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

public class TestBase {
    public static WebDriver driver;
    public WebDriverWait wait;
    JavascriptExecutor executor;

    @BeforeMethod
    public void openUrl() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);  // يقبل الشهادات غير الآمنة
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-web-security");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org");  // استخدم HTTP بدل HTTPS

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ✅ محاولة الضغط على "Send anyway" لو ظهرت رسالة تحذير الاتصال غير الآمن
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//button[contains(text(), 'Send anyway')]"))).click();
        } catch (Exception e) {
            System.out.println("No security warning or 'Send anyway' button appeared.");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenshotAndClose(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            System.out.println("Test Failed! Taking Screenshot...");
            TakesScreenshot sc = (TakesScreenshot) driver;
            File photo = sc.getScreenshotAs(OutputType.FILE);
            File screenshotDir = new File("./screenshots/");
            if (!screenshotDir.exists()) screenshotDir.mkdir();  // إنشاء فولدر لو مش موجود
            FileUtils.copyFile(photo, new File(screenshotDir, result.getName() + ".png"));
        }
        driver.quit(); // يقفل المتصفح بعد كل تيست
    }
}
