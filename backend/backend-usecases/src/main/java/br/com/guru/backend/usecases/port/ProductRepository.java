package br.com.guru.backend.usecases.port;

import br.com.guru.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {

    int create(final Product product);

    Product findById(final int id);

    List<Product> findAll();

    List<Product> findByCriteria(final Map<String, String> criteria);

    boolean update(final Product product);

    boolean delete(final int id);
}
