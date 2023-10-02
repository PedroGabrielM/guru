package br.com.guru.frontendspring.controller;

import br.com.guru.domain.UserModel;
import br.com.guru.usecases.user.ShowAllUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final ShowAllUserCase showAllUserCase;

    public UserController(ShowAllUserCase showAllUserCase) {
        this.showAllUserCase = showAllUserCase;
    }


    @GetMapping("/all")
    public String getAllUsersPage(final Model model) {

        List<UserModel> users = showAllUserCase.showAllUsers();

        model.addAttribute("users", users);

        return "/user/list";
    }
}

