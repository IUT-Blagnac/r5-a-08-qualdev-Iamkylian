package dojo;

import java.util.List;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CocktailSteps {

    private Order order;

    @Given("{string} who wants to buy a drink")
    public void someone_who_wants_to_buy_a_drink(String buyer) {
        order = new Order();
        order.declareOwner(buyer);
    }

    @When("an order is declared for {string}")
    public void an_order_is_declared_for_someone(String target) {
        order.declareTarget(target);
    }

    @Then("there is {int} cocktails in the order")
    public void there_is_cocktails_in_the_order(int nbCocktails) {
        List<String> cocktails = order.getCocktails();
        assertEquals(nbCocktails, cocktails.size());
    }

    @Then("there is no cocktail in the order")
    public void there_is_no_cocktail_in_the_order() {
        List<String> cocktails = order.getCocktails();
        assertEquals(0, cocktails.size());
    }

    @When("a message saying {string} is added")
    public void a_message_saying_is_added(String message) {
        order.setMessage(message);
    }

    @Then("the ticket must say {string}")
    public void the_ticket_must_say(String expected) {
        String ticket = order.getTicket();
        assertEquals(expected, ticket);
    }

}