package stepdefs;

import com.Estafet.TheShop.TableItems;
import io.cucumber.java.en.Then;


import java.sql.*;

public class DeletingTableDataDefinition {

    @Then("the user clears the table")
    public void clearTable() throws SQLException {
        TableItems.deleteTableItemsContent();
    }
}
