package stepdefs;

import com.Estafet.TheShop.TableItems;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

public class UpdatingDataInTables {
    String itemName;
    double itemPrice;
    int quantity;

    @When("^user enters (.*) of existing item in the table and (.*)$")
    public void argumentsToBeUpdated(String arg1, Double double1) {
        itemName = arg1;
        itemPrice = double1;
    }

    @Then("the price of the item corresponding to the name is changed")
    public void applyingIsChanged() throws SQLException {
        TableItems.updatePriceByItemName(itemName, itemPrice);

    }

    @When("user search for item {string} and then enter quantity of {int}")
    public void userInputforItemNameAndQuantity(String arg0, int arg1) {
        itemName=arg0;
        quantity=arg1;

    }

    @Then("the item quantity that corresponds to the name is updated")
    public void itemQuantityIsChanged() throws SQLException {
        TableItems.updateItemQuantity(itemName,quantity);
    }
}
