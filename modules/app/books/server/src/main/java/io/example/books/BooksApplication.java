package io.example.books;

import io.example.spring.commons.HttpMessageConvertersConfiguration;
import io.example.spring.commons.ObjectMapperCommonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        ObjectMapperCommonConfiguration.class,
        HttpMessageConvertersConfiguration.class
})
public class BooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class, args);
    }

}
