package br.com.guru.usecases.user;

import br.com.guru.domain.UserModel;
import br.com.guru.usecases.port.RestService;

import java.util.List;

public class ShowAllUserCase {
    private final RestService<UserModel> restService;

    public ShowAllUserCase(RestService<UserModel> restService) {
        this.restService = restService;
    }

    public List<UserModel> showAllUsers() {
        final String resource = "/user";
        final List<UserModel> userModels = restService.get(resource);
        return userModels;
    }
}
