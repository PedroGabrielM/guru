package br.com.guru.frontendspring.configuration;

import br.com.guru.domain.Product;
import br.com.guru.frontendspring.port.impl.RestApiController;
import br.com.guru.usecases.port.RestService;
import br.com.guru.usecases.product.ShowAllProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductFrontendAppConfiguration {

    @Bean
    public ShowAllProductUseCase showAllProductsUseCase() {
        RestService<Product> restService = new RestApiController<>();
        return new ShowAllProductUseCase(restService);
    }
}
