package br.com.guru.backend.usecases.game;

import br.com.guru.backend.usecases.exception.InvalidIdException;
import br.com.guru.backend.usecases.exception.NotFoundException;
import br.com.guru.backend.usecases.port.UserRepository;
import br.com.guru.domain.UserModel;

import java.util.List;
import java.util.Map;

public class FindGameUseCase {
    private final UserRepository userRepository;

    public FindGameUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel find(final int id){
        if (id < 0){
            throw new InvalidIdException();
        }
        UserModel user = userRepository.findById(id);
        if (user == null){
            final String message = "0 id " + id + " não foi encontrado.";
            throw new NotFoundException(message);
        }
        return user;
    }

    public List<UserModel> find(){
        List<UserModel> users = userRepository.findAll();
        if (users == null){
            return null;
        }
        return users;
    }

    public List<UserModel> find(final Map<String, String> criteria){
        if (criteria == null){
            return null;
        }
        if (criteria.size() == 0){
            return find();
        }

        final List<UserModel> byCriteria = userRepository.findByCriteria(criteria);
        return byCriteria;
    }

}
