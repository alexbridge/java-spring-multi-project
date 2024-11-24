package io.example.spring.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ObjectMapperCommonConfiguration {

    @Bean
    @Primary
    ObjectMapper objectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.LowerCamelCaseStrategy());
        return  objectMapper;
    }

    @Bean("snakeCaseObjectMapper")
    ObjectMapper snakeCaseObjectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());
        return objectMapper;
    }

    @Bean("lowerCaseObjectMapper")
    ObjectMapper lowerCaseObjectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.LowerCaseStrategy());
        return objectMapper;
    }

    @Bean("upperSnakeCaseObjectMapper")
    ObjectMapper upperSnakeCaseObjectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.UpperSnakeCaseStrategy());
        return objectMapper;
    }
}
