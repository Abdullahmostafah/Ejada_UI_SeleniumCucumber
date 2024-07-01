# EjadaSeleniumCucumber


Please implement as many of the following features as you can:
1. For UI test cases
a. Design your framework in Java, using selenium, please implement cucumber for writing the test cases in the gherkin language
b. Design your framework to support two browsers – Chrome and Firefox. Make the browser selection available from a configuration file.
c. Store the URL in the configuration file
d. Add a possibility for the tests below to be executed in parallel simultaneously
e. Implement page object model design pattern
f. Scenario One: prepare a test data file in a format of your choice, the file must contain 4 sets of data. Implement the test to run 4 times with each data set
2. Provide a report for all the test runs
3. Add a README file
4. Push your codes to a git cloud and provide the repository URL
5. If you can think of other useful features – feel free to include them as well!
UI - Test Case
Scenario One
1. Visit https://www.saucedemo.com/
2. Login with invalid credentials
3. Verify each error message
Scenario One
1- Visit https://www.saucedemo.com/
2- Login with a valid username and password
3- Verify that you’ve been logged in successfully and navigated to the products page
4- Add the most expensive two products to your cart
5- Click on the cart button
6- Verify that you’ve been navigated to “Cart” page and the previously selected products are displayed at the page
7- Click on the “Checkout” button
8- Verify that you’ve been navigated to the “Checkout” page
9- Fill all the displayed form
10- Click on the “Continue” button
11- Verify the following:
a. Verify that you’ve been navigated to the “Overview” page
b. Verify the Items total amount before taxes
c. Verify that the URL matches with (https://www.saucedemo.com/checkout-step-two.html)
12- Click on the “Finish” button
13- Verify both, the (Thank You) and the (order has been dispatched) messages
Username
Password standard_user secret_sauce
