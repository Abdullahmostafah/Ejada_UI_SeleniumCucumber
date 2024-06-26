Feature: Invalid Login

  Scenario Outline: Login with invalid credentials
    Given Open Browser on the login Page
    When login with username "<username>" and password "<password>"
    Then Error message should be appear : error message "<message>"

    Examples:
      | username | password   | message                                  |
      | invalid1 | invalidpwd | Epic sadface: Username and password do not match any user in this service |
      |          | secret_sauce | Epic sadface: Username is required       |
      | standard_user |          | Epic sadface: Password is required       |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |
