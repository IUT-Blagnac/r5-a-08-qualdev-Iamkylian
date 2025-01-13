package shoppingcart;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {

    private Cart cart;

    @Given("an empty shopping cart")
    public void anEmptyShoppingCart() {
        cart = new Cart();
    }

    @When("I add {int} {string} with unit price of {double} dollars")
    public void iAddProduct(int quantity, String product, double price) {
        cart.addItem(product, quantity, price, 0);
    }

    @When("I add {int} {string} with unit price of {double} dollars and {double} percent discount")
    public void iAddProductWithDiscount(int quantity, String product, double price, double discount) {
        cart.addItem(product, quantity, price, discount);
    }

    @Then("the cart should contain {int} items")
    public void theCartShouldContainItems(int expectedCount) {
        assertEquals(expectedCount, cart.getTotalItems());
    }

    @Then("the total amount should be {double} dollars")
    public void theTotalAmountShouldBe(double expectedAmount) {
        assertEquals(expectedAmount, cart.getTotalAmount(), 0.01);
    }
}
