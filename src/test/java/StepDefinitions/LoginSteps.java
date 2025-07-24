package StepDefinitions;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    private LoginPage loginPage;
    private HomePage homepage;

    @Given("User open the website URL")
    public void user_open_the_website_url() {
        loginPage = new LoginPage(TestBase.getDriver());
        loginPage.openWebSite();
    }

    @When("User Enter username {string} and password {string} and click on login button")
    public void user_enter_username_and_password(String username, String password) {
        loginPage.loginCredentials(username, password);
    }

    @Then("User Logged in Successfully and navigated to the products page")
    public void user_logged_in_successfully() {
        homepage = new HomePage(TestBase.getDriver());
        homepage.homePageAssertion();
    }

    @Then("Error message should be appear error message {string}")
    public void error_message_should_appear(String validationMessage) {
        loginPage.loginAssertion(validationMessage);
    }
}