package br.com.guru.backend.usecases.product;

import br.com.guru.backend.usecases.exception.InvalidIdException;
import br.com.guru.backend.usecases.exception.NotFoundException;
import br.com.guru.backend.usecases.port.ProductRepository;
import br.com.guru.domain.Product;

import java.util.List;
import java.util.Map;

public class FindProductUseCase {

    private final ProductRepository productRepository;

    public FindProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product find(final int id) {
        if(id < 0){
            throw new InvalidIdException();
        }
        Product product = productRepository.findById(id);
        if(product == null){
            final String message = "0 id" + id + "não foi encontrado.";
            throw new NotFoundException(message);
        }
        return product;
    }

    public List<Product> find(){
        List<Product> products = productRepository.findAll();
        if(products == null){
            return null;
        }
        return products;
    }

    public List<Product> find(final Map<String , String> criteria) {
        if (criteria == null){
            return null;
        }
        if (criteria.size() == 0){
            return find();
        }

        final List<Product> byCriteria = productRepository.findByCriteria(criteria);
        return byCriteria;
    }


}
