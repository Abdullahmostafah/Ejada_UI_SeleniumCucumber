//package Runners;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import java.time.Duration;
//
//public class ss {
////
////    @Test
////    public void init() {
////        WebDriver driver;
////        driver = new ChromeDriver();
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
////        driver.get("https://www.saucedemo.com/");
////        WebElement usernameField = driver.findElement(By.id("user-name"));
////        WebElement passwordField = driver.findElement(By.id("password"));
////        WebElement loginButton = driver.findElement(By.id("login-button"));
////
////        String username = "standard_user";
////        String password = "secret_sauce";
////        usernameField.sendKeys(username);
////        passwordField.sendKeys(password);
////        loginButton.click();
////
////
////
////////Empty
//////        //div[@class='error-message-container error']
//////        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
//////        String errorMessageBody = errorMessage.getText();
////
////
////
////
////        WebElement productLogo = driver.findElement(By.cssSelector(".title"));
////        String productLogoName = productLogo.getText();
////
////        SoftAssert softAssert = new SoftAssert();
////        softAssert.assertTrue(productLogoName.contains("Product"));
////
////        WebElement sortingButton = driver.findElement(By.className("product_sort_container"));
////        sortingButton.click();
////
////        Select dropdown = new Select(sortingButton);
////        dropdown.selectByValue("hilo");
//////        WebElement higherPrice = driver.findElement(By.xpath("//*[text()= 'lohi')]"));
//////        higherPrice.click();
////
////
////
////
////
////        WebElement firstHighestPrice = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
////        firstHighestPrice.click();
////
////        WebElement secondHighestPrice = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
////        secondHighestPrice.click();
////
////        WebElement shoppingCartLink = driver.findElement(By.className("shopping_cart_link"));
////        shoppingCartLink.click();
////
////
////
//
////        String cartURL = driver.getCurrentUrl();
////        softAssert.assertTrue(cartURL.contains("https://www.saucedemo.com/cart.html"));
////
////        WebElement firstItemInCart= driver.findElement(By.xpath("//*[text()='Sauce Labs Fleece Jacket']"));
////        String firstItemInCartName = firstItemInCart.getText();
////        softAssert.assertTrue(firstItemInCartName.contains("Sauce Labs Fleece Jacket"));
////
////        WebElement secondItemInCart= driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
////        String secondItemInCartName = secondItemInCart.getText();
////        softAssert.assertTrue(secondItemInCartName.contains("Sauce Labs Backpack"));
////
////        WebElement checkOutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
////        checkOutButton.click();
////
////        String checkOutURL = driver.getCurrentUrl();
////        softAssert.assertTrue(checkOutURL.contains("https://www.saucedemo.com/checkout-step-one.html"));
////
//
//        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='first-name']"));
//        firstNameField.sendKeys("Medhat");
//
//        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='last-name']"));
//        lastNameField.sendKeys("Ahmed");
//
//        WebElement postalCodeField = driver.findElement(By.name("postalCode"));
//        postalCodeField.click();
//        postalCodeField.sendKeys("15222");
//
//        WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
//        continueButton.click();
//
//
//        WebElement overviewPage = driver.findElement(By.className("title"));
//        String overViewPageTitle = overviewPage.getText();
//        softAssert.assertTrue(overViewPageTitle.contains("Checkout: Overview"));
//
//        String overViewPageURL = driver.getCurrentUrl();
//        softAssert.assertTrue(overViewPageURL.contains("https://www.saucedemo.com/checkout-step-two.html"));
//
//        WebElement totalPriceAmount = driver.findElement(By.className("summary_subtotal_label"));
//        String totalPriceAmountValue = totalPriceAmount.getText();
//        softAssert.assertTrue(totalPriceAmountValue.equals("79.88"));
//
//        WebElement finishButton = driver.findElement(By.id("finish"));
//        finishButton.click();
//
//        WebElement thankYouTextField = driver.findElement(By.className("complete-header"));
//        String thankYouTextLabel = thankYouTextField.getText();
//
//        softAssert.assertTrue(thankYouTextLabel.contains("Thank you for your order!"));
//
//
//        WebElement dispatchingTextField = driver.findElement(By.className("complete-text"));
//        String dispatchingTextLabel = dispatchingTextField.getText();
//        softAssert.assertTrue(dispatchingTextLabel.contains("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
//
//
//    driver.quit();
//    }
//
//
//}
