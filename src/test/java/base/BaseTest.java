package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public void setup() {

        ConfigReader.loadConfig();

        String url = ConfigReader.get("url");
        String browser = ConfigReader.get("browser");

        // 🔥 Browser handling
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();

        // 🔥 Wait add pannom (IMPORTANT)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}