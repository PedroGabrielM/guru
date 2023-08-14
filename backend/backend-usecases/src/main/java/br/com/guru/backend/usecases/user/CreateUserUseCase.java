package br.com.guru.backend.usecases.user;

import br.com.guru.backend.usecases.port.PasswordEncoder;
import br.com.guru.backend.usecases.port.UserRepository;
import br.com.guru.domain.UserModel;


public class CreateUserUseCase {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public CreateUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public int create(final UserModel userToBeCreated){
        if (userToBeCreated == null){
            return -1;
        }
        if (userToBeCreated.getFullName().isEmpty() || userToBeCreated.getPassword().isEmpty() || userToBeCreated.getUsername().isEmpty() || userToBeCreated.getPhoneNumber().isEmpty() || userToBeCreated.getEmail().isEmpty()){
            return -1;
        }
        if (userToBeCreated.getPassword().length() < 4){
            return -1;
        }
        final String encodePassword = passwordEncoder.encode(userToBeCreated.getPassword());
        userToBeCreated.setPassword(encodePassword);
        final int userId = userRepository.create(userToBeCreated);
        if (userId < 0){
            return -1;
        }
        return userId;
    }
}
