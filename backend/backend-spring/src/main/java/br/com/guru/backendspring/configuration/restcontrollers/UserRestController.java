package br.com.guru.backendspring.configuration.restcontrollers;

import br.com.guru.backendspring.configuration.UserBackendConfiguration;
import br.com.guru.domain.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserBackendConfiguration userBackendConfiguration = new UserBackendConfiguration();

    @GetMapping("/all")
    public List<UserModel> getUsers(){
        List<UserModel> userModel = userBackendConfiguration.findUserUseCase().find();
        return userModel;
    }
}
