package models;

public class ShippableProduct extends Products implements Shippable {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return super.toString() + ", weight = " + weight + "kg";
    }
} 
