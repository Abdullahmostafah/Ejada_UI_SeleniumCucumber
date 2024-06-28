package com.ejada.Pages;

import com.ejada.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "user-name")
    WebElement usernameField;

    @FindBy (id = "password")
    WebElement passwordField;

    @FindBy (id = "login-button")
    WebElement loginButton;


    @FindBy (xpath = "//h3[@data-test='error']")
    WebElement errorValidationContent;

    //standard_user  //secret_sauce
    public void loginCredentials (String username , String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }


    public void loginAssertion(String validationMessage){
        String errorMessages = errorValidationContent.getText();
        softAssert.assertTrue(errorMessages.contains(validationMessage),"Validation Message Not Included");
        softAssert.assertAll();
    }

}
