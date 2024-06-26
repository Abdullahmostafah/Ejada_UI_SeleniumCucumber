package Pages;

import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends TestBase {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = ".title")
    public WebElement productLogo;

    @FindBy(className = "product_sort_container")
    WebElement sortingButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    WebElement firstHighestPrice;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement secondHighestPrice;

    @FindBy (className = "shopping_cart_link")
    WebElement shoppingCartLink;

    public void sortingItems(){
        sortingButton.click();
        Select dropdown = new Select(sortingButton);
        dropdown.selectByValue("hilo");
    }

    public void addTwoExpensiveItems(){
        firstHighestPrice.click();
        secondHighestPrice.click();
    }

    public void clickOnCartLinK(){
        shoppingCartLink.click();
    }

    public void homePageAssertion(){
        String productLogoName = productLogo.getText();
        softAssert.assertTrue(productLogoName.contains("Product"),"This is not the home Page");
        softAssert.assertAll();
    }

}
