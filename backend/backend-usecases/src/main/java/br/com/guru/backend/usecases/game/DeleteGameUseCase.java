package br.com.guru.backend.usecases.game;

import br.com.guru.backend.usecases.port.UserRepository;

public class DeleteGameUseCase {
    private final UserRepository userRepository;

    public DeleteGameUseCase(UserRepository userRepository) {
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
