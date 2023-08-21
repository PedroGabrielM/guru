package br.com.guru.frontendspring.configuration;

import br.com.guru.domain.UserModel;
import br.com.guru.frontendspring.port.impl.RestApiController;
import br.com.guru.usecases.port.RestService;
import br.com.guru.usecases.user.ShowAllUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserFrontendAppConfiguration {

    @Bean
    public ShowAllUserCase showAllUserCase() {
        RestService<UserModel> restService = new RestApiController<>();
        return new ShowAllUserCase(restService);
    }
}
