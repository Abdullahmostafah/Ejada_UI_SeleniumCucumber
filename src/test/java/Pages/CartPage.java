package Pages;

import Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends TestBase {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkOutButton;

    @FindBy(xpath = "//*[text()='Sauce Labs Fleece Jacket']")
    private WebElement firstItemInCart;

    @FindBy(xpath = "//*[text()='Sauce Labs Backpack']")
    private WebElement secondItemInCart;

    public void cartURLAssertion() {
        wait.until(ExpectedConditions.urlContains("cart.html"));
        String cartURL = driver.getCurrentUrl();
        softAssert.assertTrue(cartURL.contains("https://www.saucedemo.com/cart.html"), "Invalid URL");
        softAssert.assertAll();
    }

    public void itemInCartAssertion() {
        wait.until(ExpectedConditions.visibilityOf(firstItemInCart));
        String firstItemInCartName = firstItemInCart.getText();
        softAssert.assertTrue(firstItemInCartName.contains("Sauce Labs Fleece Jacket"), "Wrong Item 1 Name");

        wait.until(ExpectedConditions.visibilityOf(secondItemInCart));
        String secondItemInCartName = secondItemInCart.getText();
        softAssert.assertTrue(secondItemInCartName.contains("Sauce Labs Backpack"), "Wrong Item 2 Name");
        softAssert.assertAll();
    }

    public void clickOnCheckOutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        checkOutButton.click();
    }

    public void checkOutAssertion() {
        wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));
        String checkOutURL = driver.getCurrentUrl();
        softAssert.assertTrue(checkOutURL.contains("https://www.saucedemo.com/checkout-step-one.html"),
                "Not a correct checkout URL");
        softAssert.assertAll();
    }
}
