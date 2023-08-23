package br.com.guru.implementation.repository;

import br.com.guru.backend.usecases.port.UserRepository;
import br.com.guru.domain.UserModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeUserDao implements UserRepository {

    private final Map<Integer, UserModel> database;

    public FakeUserDao(Map<Integer, UserModel> database) {
        this.database = new HashMap<>();
        populateData();
    }

    private static int ID = 0;

    private static int generateNextId() {
        ID += 1;
        return ID;
    }

    private void populateData() {
        final UserModel firsUser = new UserModel();
        firsUser.setEmail("email@gmail.com");
        firsUser.setId(generateNextId());
        firsUser.setUsername("user1");
        firsUser.setPassword("pass1");

        final UserModel secondUser = new UserModel();
        secondUser.setEmail("email@gmail.com");
        secondUser.setId(generateNextId());
        secondUser.setUsername("user1");
        secondUser.setPassword("pass1");


    }

    @Override
    public UserModel findById(int id) {
        return database.get(id);
    }

    @Override
    public List<UserModel> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public List<UserModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public boolean update(UserModel userModel) {

        database.put(userModel.getId(), userModel);

        return true;
    }

    @Override
    public boolean deleteById(int id) {

        UserModel removedUser = database.remove(id);

        return removedUser == null ? false : true;
    }

    @Override
    public int create(UserModel userModel) {
        userModel.setId(generateNextId());
        database.put(userModel.getId(), userModel);

        return userModel.getId();
    }
}
