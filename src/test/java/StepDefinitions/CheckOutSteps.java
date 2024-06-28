package StepDefinitions;

import com.ejada.Pages.CartPage;
import com.ejada.Pages.CheckoutPage;
import com.ejada.Base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutSteps extends TestBase {

    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("User click on checkout button")
    public void User_click_on_checkout_button(){
        cartPage = new CartPage();
        cartPage.clickOnCheckOutButton();
    }

    @Then("Verify that checkout page is displayed")
    public void Verify_that_checkout_page_is_displayed(){
        cartPage.checkOutAssertion();
    }

    @When("User fill the checkout form")
    public void User_fill_the_checkout_form(){
        checkoutPage = new CheckoutPage();
        checkoutPage.checkOutData("Ahmed" , "Alaa" , "19522");
    }

    @When("User click on continue button")
    public void User_click_on_continue_button(){
        checkoutPage.clickOnContinueButton();
    }

    @Then("User Navigated to overview page")
    public void User_Navigated_to_overview_page(){
        checkoutPage.overViewPageAssertion();
    }

    @And("Can Check total amount before taxes")
    public void Can_Check_total_amount_before_taxes(){
        checkoutPage.overAllPriceAssertion();
    }

    @And("Make Sure that CurrentURL match the displayed")
    public void Make_Sure_that_CurrentURL_match_the_displayed(){
        checkoutPage.overViewPageURLAssertion();
    }

    @When("User Click on finish button")
    public void User_Click_on_finish_button(){
        checkoutPage.clickOnFinishButton();
    }

    @Then("Thank you message and dispatching message are displayed")
    public void Thank_you_message_and_dispatching_message_are_displayed(){
        checkoutPage.completionMessageAssertions();
    }

}
