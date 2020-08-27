package stepdefs;

import com.Estafet.TheShop.TableItems;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchingForItems {
    String itemName;

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
}
