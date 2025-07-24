@Sanity
Feature: Cart and Checkout Functionality

  Scenario: Add items to cart so I can proceed to pay
    Given User filter by Highest price
    When User Add the most two expensive items
    And Click on add to cart button
    Then Cart page is opened on the selected items


  Scenario: User Check items and total amount
    Given User click on checkout button
    Then Verify that checkout page is displayed
    When User fill the checkout form
    And User click on continue button
    Then User Navigated to overview page
    And Can Check total amount before taxes
    And Make Sure that CurrentURL match the displayed
    When User Click on finish button
    Then Thank you message and dispatching message are displayed