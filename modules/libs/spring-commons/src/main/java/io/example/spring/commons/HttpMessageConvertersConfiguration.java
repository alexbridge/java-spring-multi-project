package io.example.spring.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.example.spring.commons.aspect.SnakeCase;
import io.example.spring.commons.aspect.UpperSnakeCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class HttpMessageConvertersConfiguration {
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(
            ObjectMapper objectMapper,
            @Qualifier("snakeCaseObjectMapper") ObjectMapper snakeCaseObjectMapper,
            @Qualifier("upperSnakeCaseObjectMapper") ObjectMapper upperSnakeCaseObjectMapper
    ) {
       var bean = new MappingJackson2HttpMessageConverter();
        bean.setObjectMapper(objectMapper);

        bean.registerObjectMappersForType(SnakeCase.class, m -> {
            m.put(MediaType.APPLICATION_JSON, snakeCaseObjectMapper);
        });
        bean.registerObjectMappersForType(UpperSnakeCase.class, m -> {
            m.put(MediaType.APPLICATION_JSON, upperSnakeCaseObjectMapper);
        });


        return bean;
    }
}
