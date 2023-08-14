package br.com.guru.domain.builders;

import br.com.guru.domain.UserModel;

public class UserModelBuilder {
    private int id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private UserModel.Type type;

    public UserModelBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UserModelBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserModelBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserModelBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserModelBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserModelBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserModelBuilder setType(UserModel.Type type) {
        this.type = type;
        return this;
    }

    public UserModel createUserModel() {
        return new UserModel(id, fullName, username, password, email, phoneNumber, type);
    }
}
