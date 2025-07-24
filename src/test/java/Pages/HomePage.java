package Pages;

import Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends TestBase {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "select.product_sort_container")
    private WebElement sortingButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    private WebElement firstHighestPrice;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement secondHighestPrice;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy(css = ".title")
    private WebElement productLogo;

    public void sortingItems() {
        wait.until(ExpectedConditions.visibilityOf(sortingButton));
        Select dropdown = new Select(sortingButton);
        dropdown.selectByValue("hilo");
    }

    public void addTwoExpensiveItems() {
        wait.until(ExpectedConditions.elementToBeClickable(firstHighestPrice));
        firstHighestPrice.click();
        wait.until(ExpectedConditions.elementToBeClickable(secondHighestPrice));
        secondHighestPrice.click();
    }

    public void clickOnCartLink() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink));
        shoppingCartLink.click();
    }

    public void homePageAssertion() {
        wait.until(ExpectedConditions.visibilityOf(productLogo));
        String productLogoName = productLogo.getText();
        softAssert.assertTrue(productLogoName.contains("Products"), "This is not the home page");
        softAssert.assertAll();
    }
}
