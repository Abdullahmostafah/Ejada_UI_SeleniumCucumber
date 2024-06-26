package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class LoginSteps extends TestBase {

    LoginPage loginPage;
    HomePage homepage;

    @Given("User open the website URL")
    public void User_open_the_website_URL(){
        loginPage = new LoginPage(driver);
        loginPage.openWebSite();
    }

    @When("^User Enter username \"(.*)\" and password \"(.*)\" and click on login button$")
    public void User_Enter_username_and_password_and_click_on_login_button (String username , String password){
        loginPage.loginCredentials(username,password);
    }

    @Then("User Logged in Successfully and navigated to the products page")
    public void User_Logged_in_Successfully_and_navigated_to_the_products_page(){
        homepage = new HomePage(driver);
        homepage.homePageAssertion();
    }

}
