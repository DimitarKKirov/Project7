package stepdefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Testing.Class.Class;

public class Definitions {
    Class dum = new Class();

    @Given("I have a configured Cucumber-JVM project")
    public void configuredJvm() {

        dum.configuredJVM();
    }

    @When("I run it within my IDE")
    public void runJvm() {
        dum.runIt();
    }

    @Then("I will be able to run connected step definitions")
    public void returnJvmOutput() {

        System.out.println(dum.returnOutput());
    }


}
