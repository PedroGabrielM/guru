package br.com.guru.domain;

public class Product {

    private int id;
    private Type type;
    private String name;
    private String brand;
    private double price;
    private int rating;

    public enum Type {
        SHOES,
        GLASSES,
        BAGS,
        HATS
    }

    public Product(int id, Type type, String name, String brand, double price, int rating) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.rating = rating;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
