package boa.config;

import com.deque.html.axecore.selenium.AxeBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class Hooks {

    public static WebDriver driver;
    public static Wait wait;
    public static JavascriptExecutor jsExec;
    public static AxeBuilder axeBuilder;
    public static boolean isAxesEnabled;

    @BeforeTest
    @Parameters({"browser", "enableAxes"})
    public void setupTest(String browser, String enableAxes) {
        switch(browser.toLowerCase()) {
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
        }

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        jsExec = (JavascriptExecutor) driver;

        isAxesEnabled = enableAxes.equalsIgnoreCase("true")?true:false;

        if (isAxesEnabled)
            axeBuilder = new AxeBuilder();
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
    }
}
