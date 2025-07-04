package models;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    public static void checkout(Customer customer, ShoppingCart cart) throws Exception {
        if (cart.isEmpty()) {
            throw new Exception("Cart is empty. Cannot proceed with checkout.");
        }

        double subtotal = cart.getSubtotal();
        double shippingFee = 0;
        double totalWeight = 0;
        List<Shippable> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Products product = item.getProduct();

            // Check if expired
            if (product instanceof ExpirableProduct) {
                ExpirableProduct exp = (ExpirableProduct) product;
                if (exp.isExpire()) {
                    throw new Exception("Product " + product.getName() + " is expired.");
                }
            }

            // Check if out of stock
            if (item.getQuantity() > product.getQuantity()) {
                throw new Exception("Not enough stock for product: " + product.getName());
            }

            // Add shippable items to shipping list
            if (product instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add((Shippable) product);
                    totalWeight += ((Shippable) product).getWeight();
                }
            }
        }

        // Example: 5 EGP shipping per kg
        shippingFee = totalWeight * 5;
        double total = subtotal + shippingFee;

        if (customer.getBalance() < total) {
            throw new Exception("Customer does not have enough balance.");
        }

        // Deduct quantity and balance
        for (CartItem item : cart.getItems()) {
            Products product = item.getProduct();
            product.setQuantity(product.getQuantity() - item.getQuantity());
        }
        customer.setBalance(customer.getBalance() - total);

        // Shipping process
        if (!shippableItems.isEmpty()) {
            System.out.println("** Shipment notice **");
            new ShippingService().ship(shippableItems);
            System.out.println("Total package weight " + totalWeight + "kg\n");
        }

        // Receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + (item.getProduct().getPrice() * item.getQuantity()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingFee);
        System.out.println("Amount " + total);
        System.out.println("Customer Balance After Payment: " + customer.getBalance());
        System.out.println("END.\n");
    }
} 
