package StepDefinitions;

import com.ejada.Base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks extends TestBase {

    @Before ()
    public  void runBeforeAnyScenario(){
    launchBrowser();
    }

    @After
    public  void runAfterAnyScenario(){
        tearDown();
    }
}
