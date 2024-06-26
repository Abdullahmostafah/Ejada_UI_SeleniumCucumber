@Smoke
Feature: Login with valid credentials

  Scenario Outline: User login using valid username and password
    Given User open the website URL
    When User Enter username "<username>" and password "<password>" and click on login button
    Then User Logged in Successfully and navigated to the products page
    Examples:
      |username|password|
      |standard_user|secret_sauce|


