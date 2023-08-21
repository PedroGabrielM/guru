package br.com.guru.frontendspring.controller;

import br.com.guru.domain.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/all")
    public String getAllUsersPage(final Model model) {

        List<UserModel> users = new ArrayList<>();

        UserModel user1 = new UserModel();
        user1.setId(1);
        user1.setEmail("user1@email.com");

        UserModel user2 = new UserModel();
        user2.setId(2);
        user2.setEmail("user2@email.com");

        users.add(user1);
        users.add(user2);

        model.addAttribute("usuarios", users);

        return "/user/list";
    }
}

