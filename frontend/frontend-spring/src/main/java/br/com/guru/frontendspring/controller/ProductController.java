package br.com.guru.frontendspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/all")
    public String getProductsPage(){
        return "/product/grid";
    }

    @GetMapping("/detail/{id}")
    public String getProductDetailPage(@PathVariable("id") final int id){
        return "/product/detail";
    }

}
