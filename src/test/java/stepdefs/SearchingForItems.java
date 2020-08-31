package stepdefs;

import com.Estafet.TheShop.TableItems;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.sql.SQLException;

public class SearchingForItems {
    String itemName;
    double itemPrice;
    double argument1;
    double argument2;

    @When("^User enters the name of the item in the search method like \"(.*)\"$")
    public void nameOfItem(String str1) {
        itemName = str1;
    }

    @Then("the item is found")
    public void usingSearchMethod() {
        TableItems.searchForItemByName(itemName);
    }

    @Then("printed in the console")
    public void result() {
        TableItems.printFoundItem();
    }


    @When("^user enters (\\d+\\.\\d+) for price criteria$")
    public void PriceCriteria(double price) {
        itemPrice = price;
    }

    @Then("user finds corresponding item")
    public void resultOfSearch() throws SQLException {
        TableItems.searchByPrice(itemPrice);
        TableItems.printFoundItem();
    }

    @When("^user enters minimal price (\\d+\\.\\d+) and maximum range of price (.*)$")
    public void rangeArguments(double minPrice, double maxPrice) {
        argument1 = minPrice;
        argument2 = maxPrice;
    }

    @Then("user can find all the items in this range of prices")
    public void allFoundItems() {
        TableItems.searchingByRangePrice(argument1, argument2);
        TableItems.printFoundItem();
    }
}
