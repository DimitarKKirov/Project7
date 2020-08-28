package stepdefs;

import com.Estafet.TheShop.TableItems;
import com.Estafet.TheShop.TableUsers;
import io.cucumber.java.en.Then;


import java.sql.*;

public class DeletingTableDataDefinition {

    @Then("the user clears the table")
    public void clearTable() throws SQLException {
        TableItems.deleteTableItemsContent();
    }

    @Then("the user clears table users")
    public void clearTableUsers() throws SQLException {
        TableUsers.deleteUsersContent();
    }
}
