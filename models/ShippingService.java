package models;

import java.util.List;
import java.time.LocalDate;
import models.Shippable; 

// Class: ShippingService
public class ShippingService {
    public void ship(List<Shippable> items) {
        System.out.println("ShippingService: Shipping " + items.size() + " items...");
        for (Shippable item : items) {
            System.out.println("Shipping " + item.getName() + " - " + item.getWeight() + "kg");
        }
        System.out.println("Shipping completed.\n");
    }
}

