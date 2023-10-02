package br.com.guru.frontendspring.controller;

import br.com.guru.domain.Product;
import br.com.guru.usecases.product.ShowAllProductUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ShowAllProductUseCase showAllProductCase;

    public ProductController(ShowAllProductUseCase showAllProductCase) {
        this.showAllProductCase = showAllProductCase;
    }

    @GetMapping("/all")
    public String getAllProductsPage(final Model model){

        List<Product> products = showAllProductCase.showAllProducts();

        model.addAttribute("products", products);

        return "/product/list";
    }

    @GetMapping("/detail/{id}")
    public String getProductDetailPage(@PathVariable("id") final int id){
        return "product/detail";
    }

    @GetMapping("/grid")
    public String getProductGridPage() {
        return "/product/grid";
    }

}
