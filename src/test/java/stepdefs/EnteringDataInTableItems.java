package stepdefs;

import com.Estafet.TheShop.TheShopDatabase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

public class EnteringDataInTableItems {
    String itemName;
    double itemPrice;
    int itemQuantity;

    @Given("user is connected to database TheShop")
    public void userIsConnectedToDatabase() {
        TheShopDatabase.connection();
    }

    //- Capturing arguments
    @When("user enter {string} for name")
    public void itemName(String string) {
        itemName = string;
    }

    //- Shorthand character classes
    //- The plus modifier
    //- Anchors
    @When("{double} for item price")
    public void itemPrice(String string) {
        itemPrice = Double.parseDouble(string);
    }

    //Character classes
    @When("{int} for item quantity")
    public void itemQuantity(String string) {
        itemQuantity = Integer.parseInt(string);
    }

    @Then("user added the item to the table")
    public void addItemToTable() throws SQLException {
        TheShopDatabase one = new TheShopDatabase(itemName, itemPrice, itemQuantity);
    }

    //- The Dot matcher
    //- The star modifier
    //- Multiple Captures
    //- Anchors
    @When("^user enters (.*), (.*) and (.*)$")
    public void userFillsTheFields(String string1, Double double1, Integer int1) {
        itemName = string1;
        itemPrice = double1;
        itemQuantity = int1;
    }

    @Then("the items are added to the table")
    public void itemCreation() throws SQLException {
        TheShopDatabase one = new TheShopDatabase(itemName, itemPrice, itemQuantity);
    }

}
