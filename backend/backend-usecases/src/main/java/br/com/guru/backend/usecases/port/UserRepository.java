package br.com.guru.backend.usecases.port;

import br.com.guru.domain.UserModel;

import java.util.List;
import java.util.Map;

public interface UserRepository {

    UserModel findById(final int id);

    List<UserModel> findAll();

    List<UserModel> findByCriteria(final Map<String, String> criteria);

    boolean update(final UserModel userModel);

    boolean deleteById(final int id);

    int create(final UserModel userModel);
}
