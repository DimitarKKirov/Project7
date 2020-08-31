package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"./src/test/resources/"},
        tags = {"@CreateItems, @CreateUsers, @CreateOrders, " +
                "@Items, @Users, @Orders,@itemsUpdate,@UpdatingUsersColumnData, @UpdateUsersColumn, @UpdateOrdersColumn"},
        plugin = {"pretty"},
        glue = {"stepdefs"}
)

public class HookedRunner {
}
