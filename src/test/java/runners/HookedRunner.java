package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"./src/test/resources/SQLDBTests"},
//        tags = {"@DeleteUsers, @DeleteItems"},
        plugin = {"pretty"},
        glue = {"stepdefs/SQLDBStepsDefs"}
)

public class HookedRunner {
}
