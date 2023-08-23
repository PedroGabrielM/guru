package br.com.guru.backendspring.restcontrollers;

import br.com.guru.domain.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @GetMapping("/all")
    public List<UserModel> getUsers(){
        List<UserModel> users = new ArrayList<>();

        UserModel user1 = new UserModel();
        user1.setEmail("email 1");

        UserModel user2 = new UserModel();
        user2.setEmail("email 2");

        users.add(user1);
        users.add(user2);

        return users;

    }

}
