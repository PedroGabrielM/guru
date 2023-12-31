package br.com.guru.frontendspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "/account/login";
    }

    @GetMapping("/orders")
    public String getOrdersPage(){
        return "/account/my-orders";
    }

    @GetMapping("/profile")
    public String getProfilePage(){
        return "/account/my-profile";
    }

}