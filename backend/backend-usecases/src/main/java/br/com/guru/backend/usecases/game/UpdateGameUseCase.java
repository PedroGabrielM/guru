package br.com.guru.backend.usecases.game;

import br.com.guru.backend.usecases.port.PasswordEncoder;
import br.com.guru.backend.usecases.port.UserRepository;
import br.com.guru.domain.UserModel;

public class UpdateGameUseCase {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UpdateGameUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel update(final int id, final UserModel userModel){
        if(userModel == null || id < 0){
            return null;
        }
        UserModel userToBeUpdated = userRepository.findById(id);
        if (userToBeUpdated == null){
            return null;
        }
        if (userModel.getPassword().isEmpty() || userModel.getPassword().length() < 4){
            return null;
        }
        if (userModel.getFullName().isEmpty()){
            return null;
        }
        final String encodedPassword = passwordEncoder.encode(userModel.getPassword());
        userToBeUpdated.setPassword(encodedPassword);
        userToBeUpdated.setFullName(userModel.getFullName());
        userToBeUpdated.setPhoneNumber(userModel.getPhoneNumber());

        final boolean response = userRepository.update(userToBeUpdated);
        if (response == false){
            return null;
        }
        return userToBeUpdated;
    }
}
