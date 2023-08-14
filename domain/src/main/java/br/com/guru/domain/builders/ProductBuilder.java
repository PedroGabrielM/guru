package br.com.guru.domain.builders;

import br.com.guru.domain.Product;

public class ProductBuilder {
    private int id;
    private Product.Type type;
    private String name;
    private String brand;
    private double price;
    private int rating;

    public ProductBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ProductBuilder setType(Product.Type type) {
        this.type = type;
        return this;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public Product createProduct() {
        return new Product(id, type, name, brand, price, rating);
    }
}
