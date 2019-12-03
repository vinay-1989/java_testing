package myproject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition {
	@Given("^sample feature file is ready$")
	public void givenStatement() {
		System.out.println("Given statement executed successfully");
	}
	@When("^I run the feature file$")
	public void whenStatement() {
		System.out.println("when statement will be executed");
	}
	@Then("^run should be successful$")
	public void thenaction() {
		System.out.println("Then statement would be executed");
	}
}
