package StepDefinitions;

import Base.TestBase;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCartSteps extends TestBase {
    private HomePage homepage;
    private CartPage cartPage;
    private LoginPage loginPage;

    @Given("User filter by Highest price")
    public void user_filter_by_highest_price() {
        loginPage = new LoginPage(TestBase.getDriver());
        loginPage.loginCredentials("standard_user", "secret_sauce");
        homepage = new HomePage(TestBase.getDriver());
        homepage.homePageAssertion();
        homepage.sortingItems();
    }

    @When("User Add the most two expensive items")
    public void user_add_the_most_two_expensive_items() {
        homepage.addTwoExpensiveItems();
    }

    @And("Click on add to cart button")
    public void click_on_add_to_cart_button() {
        homepage.clickOnCartLink();
    }

    @Then("Cart page is opened on the selected items")
    public void cart_page_is_opened_on_the_selected_items() {
        cartPage = new CartPage(TestBase.getDriver());
        cartPage.cartURLAssertion();
        cartPage.itemInCartAssertion();
    }
}
