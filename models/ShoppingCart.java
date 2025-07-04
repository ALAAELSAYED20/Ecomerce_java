package models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Products product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                int newQuantity = item.getQuantity() + quantity;
                items.set(items.indexOf(item), new CartItem(product, newQuantity));
                return;
            }
        }
        items.add(new CartItem(product, quantity)); 
    }

    public void removeItem(Products product) {
        items.removeIf(item -> item.getProduct().equals(product));
    }

    public CartItem getItem(Products product) {
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                return item;
            }
        }
        return null;
    }

    public double getSubtotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CartItem> getItems() {
        return items;
    }
}
