package stepdefs;

import com.Estafet.TheShop.TableItems;
import com.Estafet.TheShop.TableUsers;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

    //- Capturing arguments
    @When("^user enter \"(.*)\" for name")
    public void itemName(String name) {
        itemName = name;
    }

    //- Shorthand character classes
    //- The plus modifier
    //- Anchors
    @When("^(\\d+\\.\\d+) for item price$")
    public void itemPrice(double price) {
        itemPrice = price;
    }

    //Character classes
    @When("(\\d+) for item quantity")
    public void itemQuantity(int quantity) {
        itemQuantity = quantity;
    }

    @Then("user added the item to the table")
    public void addItemToTable() throws SQLException {
        TableItems items = new TableItems(itemName, itemPrice, itemQuantity);
    }

    //- The Dot matcher
    //- The star modifier
    //- Multiple Captures
    //- Anchors
    @When("^user enters \"(.*)\", \"(.*)\" and \"(.*)\"$")
    public void userFillsTheFields(String name, Double price, Integer quantity) {
        itemName = name;
        itemPrice = price;
        itemQuantity = quantity;
    }

    @Then("the items are added to the table")
    public void itemCreation() throws SQLException {
        TableItems items = new TableItems(itemName, itemPrice, itemQuantity);
    }

    @When("user gives input for \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\" and \"(.*)\"$")
    public void userArguments(String fName, String lName, String userCity, String userAddress,String userMail) {
        firstName = fName;
        lastName = lName;
        city = userCity;
        address = userAddress;
        eMail=userMail;
    }
    @Then("the user is registered as such in the database")
    public void addingFieldsToTableUsers() throws SQLException {
        TableUsers user = new TableUsers(firstName, lastName, city, address,eMail);
    }


}
