package br.com.guru.backendspring.configuration.restcontrollers;

import br.com.guru.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @GetMapping("/all")
    public List<Product> getProducts() {

        List<Product> products = new ArrayList<>();

        Product firstProduct = new Product();
        firstProduct.setId(1);
        firstProduct.setName("Camiseta branca");
        firstProduct.setBrand("Element");
        firstProduct.setPrice(100);
        products.add(firstProduct);

        Product secondProduct = new Product();
        secondProduct.setId(2);
        secondProduct.setName("Tenis preto");
        secondProduct.setBrand("Adidas");
        secondProduct.setPrice(800);
        products.add(secondProduct);

        Product thirdProduct = new Product();
        thirdProduct.setId(3);
        thirdProduct.setName("Shape mapple");
        thirdProduct.setBrand("Element");
        thirdProduct.setPrice(360);
        products.add(thirdProduct);

        return products;
    }
}
