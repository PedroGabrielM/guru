package br.com.guru.usecases.product;

import br.com.guru.domain.Product;
import br.com.guru.usecases.port.RestService;

import java.util.List;

public class ShowAllProductUseCase {

    private final RestService<Product> restService;

    public ShowAllProductUseCase(RestService<Product> restService) {
        this.restService = restService;
    }

    public List<Product> showAllProducts() {
        final String resource = "/product/all";
        final List<Product> products = restService.get(resource);
        return products;
    }
}
