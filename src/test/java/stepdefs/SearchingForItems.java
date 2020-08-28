package stepdefs;

import com.Estafet.TheShop.TableItems;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

public class SearchingForItems {
    String itemName;
    double itemPrice;
    double argument1;
    double argument2;

    @When("User enters the name of the item in the search method like {string}")
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
    public void PriceCriteria(double arg0) {
        itemPrice = arg0;
    }

    @Then("user finds corresponding item")
    public void resultOfSearch() throws SQLException {
        TableItems.searchByPrice(itemPrice);
        TableItems.printFoundItem();
    }

    @When("user enters minimal price {double} and maximum range of price {double}")
    public void rangeArguments(double arg0, double arg1) {
        argument1 = arg0;
        argument2 = arg1;
    }

    @Then("user can find all the items in this range of prices")
    public void allFoundItems() {
        TableItems.searchingByRangePrice(argument1, argument2);
        TableItems.printFoundItem();
    }
}
