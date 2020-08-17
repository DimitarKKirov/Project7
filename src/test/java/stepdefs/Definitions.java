package stepdefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Testing.Class.DummieClass;

public class Definitions {
    DummieClass dum = new DummieClass();

    @Given("I have a configured Cucumber-JVM project")
    public void i_have_a_configured_cucumber_jvm_project() {

        dum.configuredJVM();
    }

    @When("I run it within my IDE")
    public void i_run_it_within_my_ide() {
        dum.runIt();
    }

    @Then("I will be able to run connected step definitions")
    public void i_will_be_able_to_run_connected_step_definitions() {

        System.out.println(dum.returnOutput());
    }


}
