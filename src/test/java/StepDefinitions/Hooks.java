package StepDefinitions;

import Base.TestBase;
import Utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Hooks extends TestBase {
    @Before
    public void initDriver() {
        if (browser.equalsIgnoreCase("chrome") && driver == null) {
            ChromeOptions options = new ChromeOptions();
            // Disable password manager and related prompts
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-password-generation");
            options.addArguments("--password-store=basic");
            options.addArguments("--disable-notifications");
            options.addArguments("--incognito");

            // Set Chrome preferences to disable password manager
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            // Use a temporary user data directory to avoid profile conflicts
            options.addArguments("user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chrome-temp-profile");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(url);
            softAssert = new SoftAssert();
        } else {
            setUp(); // Fallback to TestBase setup for other browsers
        }
    }

    @After
    public void closeDriver(io.cucumber.java.Scenario scenario) {
        if (driver != null) {
            if (scenario.isFailed()) {
                String screenshotPath = ScreenshotUtils.takeScreenshot(driver, scenario.getName());
                if (screenshotPath != null && !screenshotPath.isEmpty()) {
                    try {
                        // Attach screenshot to Cucumber scenario for Extent Report
                        String relativePath = Paths.get("..", "screenshots", new File(screenshotPath).getName()).toString();
                        scenario.attach(
                                java.nio.file.Files.readAllBytes(new File(screenshotPath).toPath()),
                                "image/png",
                                "Failure Screenshot"
                        );
                        System.out.println("Screenshot attached to report: " + relativePath);
                    } catch (Exception e) {
                        System.err.println("Failed to attach screenshot to scenario '" + scenario.getName() + "': " + e.getMessage());
                    }
                } else {
                    System.err.println("Screenshot path is empty for scenario '" + scenario.getName() + "'");
                }
            }
            tearDown(); // from TestBase
        }
    }
}
