package ua.edu.oop.secondlab;

public class Product {
    private String name;
    private double price;
    private int rating;

    public Product(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getRating() { return rating; }

    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return name + " | " + price + " грн | rating=" + rating;
    }
}