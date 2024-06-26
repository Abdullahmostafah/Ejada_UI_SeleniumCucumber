package Pages;

import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends TestBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastNameField;

    @FindBy(name = "postalCode")
    WebElement postalCodeField;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;

    @FindBy(className = "complete-header")
    WebElement thankYouTextField;

    @FindBy(className = "complete-text")
    WebElement dispatchingTextField;

    @FindBy(className = "title")
    WebElement overviewPage ;

    @FindBy(className = "summary_subtotal_label")
    WebElement totalPriceAmount;

    @FindBy (id = "finish")
    WebElement finishButton;


    public void checkOutData(String firstname, String lastname , String postalcode){
        firstNameField.sendKeys(firstname);
        lastNameField.sendKeys(lastname);
        postalCodeField.click();
        postalCodeField.sendKeys(postalcode);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void overViewPageAssertion(){
        String overViewPageTitle = overviewPage.getText();
        softAssert.assertTrue(overViewPageTitle.contains("Checkout: Overview"),"Invalid page title");
        softAssert.assertAll();
    }

    public void overAllPriceAssertion(){
        String totalPriceAmountValue = totalPriceAmount.getText();
        softAssert.assertTrue(totalPriceAmountValue.equals("79.88"),"Wrong Calculation");
        softAssert.assertAll();

    }

    public void overViewPageURLAssertion() {
        String overViewPageURL = driver.getCurrentUrl();
        softAssert.assertTrue(overViewPageURL.contains("https://www.saucedemo.com/checkout-step-two.html"), "Invalid URL");
        softAssert.assertAll();
    }


    public void clickOnFinishButton(){
        finishButton.click();
    }

    public void completionMessageAssertions(){
        String thankYouTextLabel = thankYouTextField.getText();
        softAssert.assertTrue(thankYouTextLabel.contains("Thank you for your order!"));
        String dispatchingTextLabel = dispatchingTextField.getText();
        softAssert.assertTrue(dispatchingTextLabel.contains("Your order has been dispatched, and will arrive just as fast as the pony can get there!"),"Process not completed");
        softAssert.assertAll();
    }


}
