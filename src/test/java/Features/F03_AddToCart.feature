@Smoke
Feature: Add to cart

  Scenario: Add items to cart so I can proceed to pay
    Given User filter by Highest price
    When User Add the most two expensive items
    And Click on add to cart button
    Then Cart page is opened on the selected items

