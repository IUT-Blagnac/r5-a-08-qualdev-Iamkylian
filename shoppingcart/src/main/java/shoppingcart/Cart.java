package shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(String name, int quantity, double price, double discount) {
        Item item = new Item(name, quantity, price, discount);
        items.add(item);
    }

    public int getTotalItems() {
        return items.stream()
                .mapToInt(Item::getQuantity)
                .sum();
    }

    public double getTotalAmount() {
        return items.stream()
                .mapToDouble(item -> item.getFinalPrice() * item.getQuantity())
                .sum();
    }
}

class Item {

    private String name;
    private int quantity;
    private double price;
    private double discount;

    public Item(String name, int quantity, double price, double discount) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public double getFinalPrice() {
        return price * (1 - discount / 100);
    }
}
