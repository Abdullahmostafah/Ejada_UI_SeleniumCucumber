@Sanity
Feature: Login Functionality

  Scenario Outline: Login with invalid credentials
    Given User open the website URL
    When User Enter username "<username>" and password "<password>" and click on login button
    Then Error message should be appear error message "<message>"

    Examples:
      | username        | password     | message                                                                   |
      | invalid1        | invalidpwd   | Epic sadface: Username and password do not match any user in this service |
      |                 | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user   |              | Epic sadface: Password is required                                        |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |


  Scenario Outline: User login using valid username and password
    Given User open the website URL
    When User Enter username "<username>" and password "<password>" and click on login button
    Then User Logged in Successfully and navigated to the products page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |