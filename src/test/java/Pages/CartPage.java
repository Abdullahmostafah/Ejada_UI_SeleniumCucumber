package Pages;

import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends TestBase {

    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Sauce Labs Fleece Jacket']")
    WebElement firstItemInCart;


    @FindBy(xpath = "//*[text()='Sauce Labs Backpack']")
    WebElement secondItemInCart;

    @FindBy (xpath = "//button[@id='checkout']")
    WebElement checkOutButton;



    public void cartURLAssertion(){
        String cartURL = driver.getCurrentUrl();
        softAssert.assertTrue(cartURL.contains("https://www.saucedemo.com/cart.html"),"Invalid URL");
        softAssert.assertAll();
    }

    public void itemInCartAssertion(){
        String firstItemInCartName = firstItemInCart.getText();
        softAssert.assertTrue(firstItemInCartName.contains("Sauce Labs Fleece Jacket"),"Wrong Item 1 Name");

        String secondItemInCartName = secondItemInCart.getText();
        softAssert.assertTrue(secondItemInCartName.contains("Sauce Labs Backpack"), "Wrong Item 2 Name");
        softAssert.assertAll();
    }

    public void clickOnCheckOutButton(){
        checkOutButton.click();

    }

    public void checkOutAssertion(){
        String checkOutURL = driver.getCurrentUrl();
        softAssert.assertTrue(checkOutURL.contains("https://www.saucedemo.com/checkout-step-one.html"),"Not a correct checkout URL");
        softAssert.assertAll();
    }








}
