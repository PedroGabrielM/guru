package br.com.guru.backendspring.configuration;

import br.com.guru.backend.usecases.port.UserRepository;
import br.com.guru.backend.usecases.user.FindUserUseCase;
import br.com.guru.implementation.repository.FakeUserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBackendConfiguration {

    private final UserRepository userRepository;

    public UserBackendConfiguration() {
        this.userRepository = new FakeUserDao();
    }

    @Bean
    public FindUserUseCase findUserUseCase() {
        return new FindUserUseCase(userRepository);
    }
}
