package io.example.books.api.books;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.example.books.api.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice("io.example.books.api.books")
@RequiredArgsConstructor
public class BooksControllerAdvice implements ResponseBodyAdvice<Book> {
    private final ObjectMapper commonObjectMapper;
    @Qualifier("snakeCaseObjectMapper")
    private final ObjectMapper snakeCaseObjectMapper;
    @Qualifier("lowerCaseObjectMapper")
    private final ObjectMapper lowerCaseObjectMapper;
    @Qualifier("upperSnakeCaseObjectMapper")
    private final ObjectMapper upperSnakeCaseObjectMapper;
    private final MappingJackson2HttpMessageConverter converter;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getParameterType() == Book.class;
    }

    @Override
    public Book beforeBodyWrite(
            Book body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response
    ) {
        if (body.getId().equals("2")) {
            converter.setObjectMapper(snakeCaseObjectMapper);
        }
        if (body.getId().equals("3")) {
            converter.setObjectMapper(lowerCaseObjectMapper);
        }
        if (body.getId().equals("4")) {
            converter.setObjectMapper(upperSnakeCaseObjectMapper);
        }
        return body;
    }
}
