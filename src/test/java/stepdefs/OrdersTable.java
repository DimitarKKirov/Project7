package stepdefs;

import com.Estafet.TheShop.Orders;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import java.sql.SQLException;

public class OrdersTable {
    String itemName;
    String eMail;

    @When("^user with E-mail \"(.*)\" orders \"(.*)\" from the shop$")
    public void userOrders(String email,String item) {
        itemName = item;
        eMail=email;
    }

    @Then("user created order in the Order table")
    public void createdOrder() throws SQLException {
        Orders.userBuyingItem(eMail,itemName);
    }

    @When("^this \"(.*)\" make orders for an \"(.*)\"$")
    public void usersOrders(String mail, String item) {
    itemName=item;
    eMail=mail;
    }

    @Then("^the bought item is subtracted from the item quantity and Orders are created$")
    public void usersAreOrderingTheItems() throws SQLException {
        Orders.userBuyingItem(eMail,itemName);

    }
}
