package io.example.book.http;

import io.example.book.api.BooksApi;
import io.example.http.interceptor.LoggingRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ApiBooksHttpConfiguration {
    @Value("${io.example.api.book.base-url}")
    String baseUrl;

    @Bean
    BooksApi booksHttpClient() {
        var client = RestClient.builder()
                .baseUrl(baseUrl)
                .requestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
                .requestInterceptor(new LoggingRequestInterceptor())
                .build();

        return HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(client))
                .build()
                .createClient(BooksApi.class);
    }
}
