package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src//test//resources"},
        plugin = {"json:target/cucumber.json"},
//        tags = ("@CreateItems and @CreateUsers and @Items"),
        glue = {"stepdefs"},
        dryRun = false
)
public class HookedRunner {
}
