package TestBase;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestBase {
  public WebDriver driver;

    public static String browser = "Chrome";
    public static String base_url = "https://www.saucedemo.com/";

    public SoftAssert softAssert = new SoftAssert();

    public TestBase() {
        super();
    }

    public void configureChromeBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void configureFireFoxBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Before
    public void setBrowser() {
        switch (browser.toLowerCase()) {
            case "chrome" -> {
                configureChromeBrowser();
            }
            case "firefox" -> {
                configureFireFoxBrowser();
            }
            default -> throw new IllegalArgumentException("Invalid browser: " + browser);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }}