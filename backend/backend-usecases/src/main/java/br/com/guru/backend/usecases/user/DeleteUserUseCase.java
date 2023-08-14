package br.com.guru.backend.usecases.user;

import br.com.guru.backend.usecases.port.UserRepository;

public class DeleteUserUseCase {

    private final UserRepository userRepository;

    public DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean delete(final int id){
        if (id < 0){
            return false;
        }
        boolean response = userRepository.deleteById(id);

        return response;
    }
}