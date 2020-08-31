package stepdefs;

import com.Estafet.TheShop.TableItems;
import com.Estafet.TheShop.TableUsers;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import java.sql.SQLException;
import java.util.List;

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
    public void applyingChange() throws SQLException {
        TableItems.updatePriceByItemName(itemName, itemPrice);

    }

    @Then("user changes the quantity value of needed item")
    public void userInputForItemNameAndQuantity(DataTable table) throws SQLException {
        int a = 1;
        List<List<String>> stepData = table.raw();
        for (int i = 0; i < stepData.size() - 1; i++) {
            itemName = stepData.get(a).get(0);
            quantity = Integer.parseInt(stepData.get(a).get(1));
            TableItems.updateItemQuantity(itemName, quantity);
            a++;
        }
    }


    @Then("we updated the Postal Code for users living in the USA with input for \"(.*)\", \"(.*)\" and user \"(.*)\"$")
    public void weUpdatedThePostalCodeForUsersLivingInUSWithInputForAndUserEmail(String column, String zipCode, String email) throws Throwable {
        TableUsers.updateZipOrPostalCode(column,email, zipCode);
    }

    @Then("^we updated the Postal Code for users living in BG with input for \"(.*)\", \"(.*)\" and user \"(.*)\"$")
    public void weUpdatedThePostalCodeForUsersLivingInBGWithInputForAndUser(String column, String postalCode, String eMail) throws Throwable {
        TableUsers.updateZipOrPostalCode(column, eMail, postalCode);
    }

}
