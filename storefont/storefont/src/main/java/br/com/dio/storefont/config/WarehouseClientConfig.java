package br.com.dio.storefont.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class WarehouseClientConfig {
    @Bean
    RestClient storefrontClient(@Value("${warehouse.base-path}") final String basePath){
        return RestClient.create(basePath);
    }
}
