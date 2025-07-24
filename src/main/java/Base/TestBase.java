package Base;

import Utils.ConfigReaderWriter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestBase {
    protected static WebDriver driver;
    protected static SoftAssert softAssert = new SoftAssert();
    protected static String browser = ConfigReaderWriter.getPropKey("browser");
    protected static String url = ConfigReaderWriter.getPropKey("url");

    public static void initializeDriver() {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    public void setUp() {
        softAssert = new SoftAssert();
        initializeDriver();
        driver.get(url);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset driver to null after quitting
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }
}
