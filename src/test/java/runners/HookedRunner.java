package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"./src/test/resources/"},
//        tags = {"@CreateItems,@CreateUsers,@CreateOrders,@ignore @UpdateUsersColumn, @UpdateOrdersColumn," +
//                "@Items,@Users,@Orders,@DeleteUsers,@DeleteItems"},
        plugin = {"pretty"},
        glue = {"stepdefs"}
)

public class HookedRunner {
}
