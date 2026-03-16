package org.prog.session18.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MySteps {

    @Given("Preconditions are {string}")
    public void preconditionsAreOK(String value) {
        System.out.println(">>>> Preconditions are " + value);
    }

    @Given("Set user password to {string}")
    public void setUserPassword(String value) {
        System.out.println(">>>> User password is set to " + value);
    }

    @Given("There parameters are {string} and {string}")
    public void parametersDemo(String value1, String value2) {
        System.out.println(">>>> There parameters are " + value1 + " and " + value2);
    }

    @When("I do something {int} times")
    public void iDoSomething(int i) {
        for (int j = 1; j <= i; j++) {
            System.out.println(">>>> I do something " + j + " times");
        }
    }

    @Then("Something happens with {}")
    public void somethingHappens(MyEnum myEnum) {
        System.out.println("Something happens with " + myEnum.name());
    }
}
