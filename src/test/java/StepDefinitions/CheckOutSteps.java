package StepDefinitions;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.ConfigReaderWriter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutSteps extends TestBase {
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;
    private HomePage homepage;

    @Given("User click on checkout button")
    public void user_click_on_checkout_button() {
        // Login and add items to cart
        loginPage = new LoginPage(TestBase.getDriver());
        loginPage.loginCredentials("standard_user", "secret_sauce");
        homepage = new HomePage(TestBase.getDriver());
        homepage.homePageAssertion();
        homepage.sortingItems();
        homepage.addTwoExpensiveItems();
        homepage.clickOnCartLink();
        cartPage = new CartPage(TestBase.getDriver());
        cartPage.clickOnCheckOutButton();
    }

    @Then("Verify that checkout page is displayed")
    public void verify_that_checkout_page_is_displayed() {
        cartPage.checkOutAssertion();
    }

    @When("User fill the checkout form")
    public void user_fill_the_checkout_form() {
        checkoutPage = new CheckoutPage(TestBase.getDriver());
        checkoutPage.checkOutData("Ahmed", "Alaa", "19522");
    }

    @When("User click on continue button")
    public void user_click_on_continue_button() {
        checkoutPage.clickOnContinueButton();
    }

    @Then("User Navigated to overview page")
    public void user_navigated_to_overview_page() {
        checkoutPage.overViewPageAssertion();
    }

    @And("Can Check total amount before taxes")
    public void can_check_total_amount_before_taxes() {
        checkoutPage.overAllPriceAssertion();
    }

    @And("Make Sure that CurrentURL match the displayed")
    public void make_sure_that_current_url_match_the_displayed() {
        checkoutPage.overViewPageURLAssertion();
    }

    @When("User Click on finish button")
    public void user_click_on_finish_button() {
        checkoutPage.clickOnFinishButton();
    }

    @Then("Thank you message and dispatching message are displayed")
    public void thank_you_message_and_dispatching_message_are_displayed() {
        checkoutPage.completionMessageAssertions();
    }
}