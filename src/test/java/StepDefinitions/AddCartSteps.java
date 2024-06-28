package StepDefinitions;

import com.ejada.Pages.CartPage;
import com.ejada.Pages.HomePage;

import com.ejada.Base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCartSteps extends TestBase {

    HomePage homepage;
    CartPage cartPage;

    @Given("User filter by Highest price")
    public void User_filter_by_Highest_price()
    {
        homepage = new HomePage();
        homepage.sortingItems();
    }
    @When("User Add the most two expensive items")
    public void User_Add_the_most_two_expensive_items(){
        homepage.addTwoExpensiveItems();
    }

    @And("Click on add to cart button")
    public void Click_on_add_to_cart_button(){
        homepage.clickOnCartLinK();
    }

    @Then("Cart page is opened on the selected items")
    public void Cart_page_is_opened_on_the_selected_items(){
        cartPage = new CartPage();
        cartPage.cartURLAssertion();
        cartPage.itemInCartAssertion();
    }
}
