package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features",
        glue = "StepDefinitions",
        tags = "@Sanity",
        plugin = {
                "pretty",
                "html:target/reports/cucumber.html",
                "json:target/reports/cucumber.json",
                "junit:target/reports/cukes.xml",
                "rerun:target/reports/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
