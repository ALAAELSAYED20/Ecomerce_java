import java.time.LocalDate;

import models.Products;
import models.ShoppingCart;
import models.CartItem;
import models.Customer;
import models.CheckoutService;
import models.ShippableProduct;

public class Main {
    public static void main(String[] args) {
        Products cheese = new ShippableProduct("Cheese", 100.0, 5, 0.4);
        Products biscuits = new ShippableProduct("Biscuits", 150.0, 3, 0.7); 

      
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(cheese, 2); 
        cart.addItem(biscuits, 1); 

        // Print cart items
        for (CartItem item : cart.getItems()) {
            System.out.println(item);
        }

        System.out.println("Subtotal = " + cart.getSubtotal());

        // Create customer
        Customer customer = new Customer("Alaa", 1000);
        System.out.println(customer);

        // Checkout
        try {
            CheckoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Checkout error: " + e.getMessage());
        }
    }
}
