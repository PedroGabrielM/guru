package br.com.guru.frontendspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/")
    public String getHomePage(){
        return "/index";
    }

    @GetMapping("/not-found")
    public String getNotFound(){
        return "/common/not-found";
    }

    @GetMapping("/about")
    public String getAboutPage(){
        return "/common/about";
    }

}
