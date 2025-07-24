package Pages;

import Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorValidationContent;

    public void loginCredentials(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void loginAssertion(String validationMessage) {
        String errorMessages = errorValidationContent.getText();
        softAssert.assertTrue(errorMessages.contains(validationMessage),
                "Validation Message Not Included");
        softAssert.assertAll();
    }

    public void openWebSite() {
        driver.get(url);
    }
}
