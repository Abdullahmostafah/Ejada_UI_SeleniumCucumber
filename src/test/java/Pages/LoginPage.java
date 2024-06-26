package Pages;

import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "user-name")
    WebElement usernameField;

    @FindBy (id = "password")
    WebElement passwordField;

    @FindBy (id = "login-button")
    WebElement loginButton;

    public void openWebSite(){
        driver.get(base_url);
    }

    //standard_user  //secret_sauce
    public void loginCredentials (String username , String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

}
