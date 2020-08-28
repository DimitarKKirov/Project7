package stepdefs;

import com.Estafet.TheShop.TableItems;
import com.Estafet.TheShop.TableUsers;
import com.Estafet.TheShop.TheShopDatabase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

public class EnteringDataInTables {
    private String itemName;
    private double itemPrice;
    private int itemQuantity;
    private String firstName;
    private String lastName;
    private String city;
    private String address;
    private String eMail;

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
    @When("^(\\d+\\.\\d+) for item price$")
    public void itemPrice(double arg0) {
        itemPrice = arg0;
    }

    //Character classes
    @When("{int} for item quantity")
    public void itemQuantity(int arg0) {
        itemQuantity = arg0;
    }

    @Then("user added the item to the table")
    public void addItemToTable() throws SQLException {
        TableItems items = new TableItems(itemName, itemPrice, itemQuantity);
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
        TableItems items = new TableItems(itemName, itemPrice, itemQuantity);
    }

    @When("^user gives input for (.*), (.*), (.*), (.*) and (.*)$")
    public void userArguments(String arg1, String arg2, String arg3, String arg4,String arg5) {
        firstName = arg1;
        lastName = arg2;
        city = arg3;
        address = arg4;
        eMail=arg5;
    }

    @Then("the user is registered as such in the database")
    public void addingFieldsToTableUsers() throws SQLException {
        TableUsers user = new TableUsers(firstName, lastName, city, address,eMail);
    }


}
