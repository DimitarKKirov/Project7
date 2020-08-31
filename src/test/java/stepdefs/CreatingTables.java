package stepdefs;

import com.Estafet.TheShop.TableItems;
import com.Estafet.TheShop.TheShopDatabase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


import java.sql.*;
import java.util.List;


public class CreatingTables {

    //nonCapturing groups
    @Given("(?:we are|user is) connected to database TheShop")
    public void userIsConnectedToDatabase() {
        TheShopDatabase.connectionGiven();
    }

    @Then("we crate Table Items")
    public void crateTableItem() throws SQLException {
        TheShopDatabase.createTableItems();
    }

    //question mark modifier
    @Then("^?he crates table Users$")
    public void crateTableUsers() throws SQLException {
        TheShopDatabase.createTableUsers();
    }

    @Then("(?:user is|we are) creating Table Orders in database TheShop")
    public void crateTableOrdersInDatabaseTheShop() throws SQLException {
        TheShopDatabase.createOrdersTable();
    }

    @Then("^user updates table Orders with column \"(.*)\" and type of column \"(.*)\"$")
    public void updateOrdersColumn(String column, String columnType) {
        TheShopDatabase.updateOrdersColumn(column, columnType);
    }

    @Then("^user adds this columns with this value types:$")
    public void updateUsersColumn(DataTable table) {
        int a = 1;
        String columnName;
        String columnType;
        List<List<String>> stepData = table.raw();
        for (int i = 0; i < stepData.size() - 1; i++) {
            columnName = stepData.get(a).get(0);
            columnType = stepData.get(a).get(1);
            TheShopDatabase.updateUsersColumn(columnName, columnType);
            a++;
        }
    }
}

