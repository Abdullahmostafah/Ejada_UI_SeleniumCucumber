# Ejada_UI_SeleniumCucumber

This project is a UI test automation framework built with **Java**, **Selenium WebDriver**, **Cucumber**, and the **Page Object Model (POM)** design pattern. It automates testing for the [SauceDemo](https://www.saucedemo.com/) website, supporting both **Chrome** and **Firefox** browsers with configurable settings. The framework includes parallel execution, data-driven testing, and detailed reporting using **Extent Reports**.

## Features
- **Cucumber with Gherkin**: Test cases are written in Gherkin syntax for readability and maintainability.
- **Multi-Browser Support**: Configurable browser selection (Chrome or Firefox) via `extent.properties`.
- **Page Object Model (POM)**: Organized page classes (e.g., `LoginPage`, `ProductsPage`) for maintainable test code.
- **Data-Driven Testing**: Executes tests with multiple data sets from a test data file.
- **Parallel Execution**: Supports running tests concurrently using TestNG and Cucumber.
- **Extent Reports**: Generates detailed HTML reports with scenario names, steps, and screenshots for failed tests (saved in `dd-MM-yyyy-HH-mm-ss` format).
- **Screenshot Capture**: Captures screenshots for failed scenarios, stored in `target/screenshots/`.
- **Chrome Password Popup Handling**: Configured to suppress Chrome's password save popup using `ChromeOptions`.

## Prerequisites
- **Java**: JDK 21
- **Maven**: 3.8.6 or later
- **Browsers**:
  - Google Chrome (with ChromeDriver compatible with `selenium-java:4.34.0`)
  - Mozilla Firefox (with GeckoDriver compatible with `selenium-java:4.34.0`)
- **Git**: For cloning the repository
- **IDE**: IntelliJ IDEA, Eclipse, or similar (optional)

## Project Structure
```
Ejada_UI_SeleniumCucumber/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── Pages/                # Page Object Model classes (e.g., LoginPage.java)
│   │   │   ├── StepDefinitions/      # Cucumber step definitions (e.g., LoginSteps.java, Hooks.java)
│   │   │   ├── Utils/               # Utility classes (e.g., ScreenshotUtils.java)
│   │   │   └── Base/                # Base class (TestBase.java)
│   ├── test/
│   │   ├── java/
│   │   │   └── Runners/             # Test runner (TestRunner.java)
│   │   ├── resources/
│   │   │   ├── features/            # Gherkin feature files (e.g., Login.feature)
│   │   │   └── extent.properties    # Configuration file for browser, URL, and reporting
├── target/
│   ├── reports/                     # Extent Report output (ExtentReport.html)
│   ├── screenshots/                 # Screenshots for failed tests
├── pom.xml                          # Maven dependencies and build configuration
├── testng.xml                       # TestNG configuration for parallel execution
├── .gitignore                       # Git ignore file
└── README.md                        # Project documentation
```

## Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Abdullahmostafah/Ejada_UI_SeleniumCucumber.git
   cd Ejada_UI_SeleniumCucumber
   ```

2. **Install Dependencies**:
   - Ensure Maven is installed.
   - Run:
     ```bash
     mvn clean install
     ```

3. **Configure Browser and URL**:
   - Edit `src/test/resources/extent.properties`:
     ```properties
     browser=chrome  # or firefox
     url=https://www.saucedemo.com/
     extent.reporter.spark.start=true
     extent.reporter.spark.out=target/reports/ExtentReport.html
     extent.reporter.spark.cucumber.scenario.name=true
     screenshot.dir=target/screenshots/
     screenshot.rel.path=../screenshots/
     total.amount=79.98
     ```

4. **Set Up WebDrivers**:
   - **Chrome**: Ensure ChromeDriver is installed and matches your Chrome version. Set the path in `TestBase.java` or use WebDriverManager.
   - **Firefox**: Ensure GeckoDriver is installed and matches your Firefox version.
   - Alternatively, use WebDriverManager (included in `pom.xml`) to handle driver setup automatically.



## Test Scenarios
### Scenario One: Invalid Login
- **Steps**:
  1. Visit `https://www.saucedemo.com/`.
  2. Login with invalid credentials (4 sets from test data).
  3. Verify the error message for each attempt.
- **Feature File**: `src/test/resources/features/Login.feature`
- **Step Definitions**: `src/main/java/StepDefinitions/LoginSteps.java`
- **Data-Driven**: Uses `@DataTable` or external file (e.g., `login_data.csv`) to run 4 times.

### Scenario Two: Valid Login and Checkout
- **Steps**:
  1. Visit `https://www.saucedemo.com/`.
  2. Login with valid credentials (`standard_user`, `secret_sauce`).
  3. Verify navigation to the Products page.
  4. Add the two most expensive products to the cart.
  5. Click the cart button and verify the Cart page.
  6. Click Checkout and verify the Checkout page.
  7. Fill the checkout form and click Continue.
  8. Verify the Overview page, total amount (`79.98`), and URL (`https://www.saucedemo.com/checkout-step-two.html`).
  9. Click Finish and verify the "Thank You" and "order dispatched" messages.
- **Feature File**: `src/test/resources/features/Checkout.feature`
- **Step Definitions**: `src/main/java/StepDefinitions/CheckoutSteps.java`

## Running Tests
1. **Run All Tests**:
   ```bash
   mvn clean test
   ```

2. **Parallel Execution**:
   - Configured in `testng.xml`:
     ```xml
     <suite name="Test Suite" parallel="tests" thread-count="2">
         <test name="Chrome Tests">
             <parameter name="browser" value="chrome"/>
             <classes>
                 <class name="Runners.TestRunner"/>
             </classes>
         </test>
         <test name="Firefox Tests">
             <parameter name="browser" value="firefox"/>
             <classes>
                 <class name="Runners.TestRunner"/>
             </classes>
         </test>
     </suite>
     ```
   - Run:
     ```bash
     mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
     ```

3. **View Report**:
   - Open `target/reports/ExtentReport.html` in a browser.
   - Screenshots for failed tests are saved in `target/screenshots/` with format `<scenario>_<dd-MM-yyyy-HH-mm-ss>.png`.


## Additional Features
- **SLF4J Logging**: Integrated in `Hooks.java`, `LoginSteps.java`, and `ScreenshotUtils.java` for detailed console logs.
- **Soft Assertions**: Uses TestNG `SoftAssert` to continue tests after assertion failures.
- **Configurable Waits**: Implicit waits and explicit `WebDriverWait` for robust element handling.

## Contributing
- Fork the repository.
- Create a feature branch (`git checkout -b feature/your-feature`).
- Commit changes (`git commit -m "Add feature"`).
- Push to the branch (`git push origin feature/your-feature`).
- Create a Pull Request.

## Contact
For issues or suggestions, contact [Abdullahmostafah](https://github.com/Abdullahmostafah).
