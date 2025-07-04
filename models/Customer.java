package models;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
    public double setBalance(double balance){
        return this.balance=balance;
    }

    public void deduct(double amount) {
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return name + " | Balance: " + balance + " EGP";
    }
}
