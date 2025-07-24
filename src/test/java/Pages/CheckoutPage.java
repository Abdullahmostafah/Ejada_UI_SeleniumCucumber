package Pages;

import Base.TestBase;
import Utils.ConfigReaderWriter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends TestBase {
    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;

    @FindBy(name = "postalCode")
    private WebElement postalCodeField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(className = "complete-header")
    private WebElement thankYouTextField;

    @FindBy(className = "complete-text")
    private WebElement dispatchingTextField;

    @FindBy(className = "title")
    private WebElement overviewPage;

    @FindBy(className = "summary_subtotal_label")
    private WebElement totalPriceAmount;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public void checkOutData(String firstname, String lastname, String postalcode) {
        firstNameField.sendKeys(firstname);
        lastNameField.sendKeys(lastname);
        postalCodeField.sendKeys(postalcode);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void overViewPageAssertion() {
        String overViewPageTitle = overviewPage.getText();
        softAssert.assertTrue(overViewPageTitle.contains("Checkout: Overview"), "Invalid page title");
        softAssert.assertAll();
    }

    public void overAllPriceAssertion() {
        String expectedTotal = ConfigReaderWriter.getPropKey("total.amount");
        String totalPriceAmountValue = totalPriceAmount.getText();
        softAssert.assertTrue(totalPriceAmountValue.contains(expectedTotal), "Wrong Calculation: Expected " + expectedTotal);
        softAssert.assertAll();
    }

    public void overViewPageURLAssertion() {
        String overViewPageURL = driver.getCurrentUrl();
        softAssert.assertTrue(overViewPageURL.contains("https://www.saucedemo.com/checkout-step-two.html"), "Invalid URL");
        softAssert.assertAll();
    }

    public void clickOnFinishButton() {
        finishButton.click();
    }

    public void completionMessageAssertions() {
        String thankYouTextLabel = thankYouTextField.getText();
        softAssert.assertTrue(thankYouTextLabel.contains("Thank you for your order!"), "Thank you message not displayed");
        String dispatchingTextLabel = dispatchingTextField.getText();
        softAssert.assertTrue(dispatchingTextLabel.contains("Your order has been dispatched, and will arrive just as fast as the pony can get there!"), "Dispatching message not displayed");
        softAssert.assertAll();
    }
}
