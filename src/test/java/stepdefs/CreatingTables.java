package stepdefs;

import com.Estafet.TheShop.TheShopDatabase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.*;


public class CreatingTables {
    @Given("we are connected to database TheShop")
    public void weAreConnected() {
        TheShopDatabase.connection();
    }

    @Then("we crate Table item in database TheShop")
    public void crateTableItem() throws SQLException {
        TheShopDatabase.createTableItems();
    }

    @Then("^he\\/she crate Table users in database TheShop$")
    public void crateTableUsers() throws SQLException {
        TheShopDatabase.createTableUsers();
    }
}
