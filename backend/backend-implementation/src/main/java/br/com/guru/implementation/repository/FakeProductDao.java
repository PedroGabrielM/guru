package br.com.guru.implementation.repository;

import br.com.guru.backend.usecases.port.ProductRepository;
import br.com.guru.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeProductDao implements ProductRepository {

    private final Map<Integer, Product> database;

    public FakeProductDao() {
        this.database = new HashMap<>();
        populateData();
    }

    private static int ID = 0;

    private static int generateNextId() {
        ID += 1;
        return ID;
    }

    private void populateData() {
        final Product firstProduct = new Product();
        firstProduct.setId(generateNextId());
        firstProduct.setName("Camiseta branca");
        firstProduct.setBrand("Element");
        firstProduct.setPrice(100);
        database.put(firstProduct.getId(), firstProduct);

        final Product secondProduct = new Product();
        secondProduct.setId(generateNextId());
        secondProduct.setName("Tenis preto");
        secondProduct.setBrand("Adidas");
        secondProduct.setPrice(800);
        database.put(secondProduct.getId(), secondProduct);

        final Product thirdProduct = new Product();
        thirdProduct.setId(generateNextId());
        thirdProduct.setName("Shape mapple");
        thirdProduct.setBrand("Element");
        secondProduct.setPrice(360);
        database.put(thirdProduct.getId(), thirdProduct);
    }

    @Override
    public int create(Product product) {

        product.setId(generateNextId());
        database.put(product.getId(), product);

        return product.getId();
    }

    @Override
    public Product findById(int id) {
        return database.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public List<Product> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public boolean update(Product product) {

        database.put(product.getId(), product);

        return true;
    }

    @Override
    public boolean delete(int id) {

        Product productToRemove = database.remove(id);


        return productToRemove == null ? false : true;
    }

}
