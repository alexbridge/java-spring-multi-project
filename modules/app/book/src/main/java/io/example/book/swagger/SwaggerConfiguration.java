package io.example.book.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openApi() {
        var server = new Server();
        //server.url(apiServerName);

        return new OpenAPI()
                .info(
                        new Info()
                                .title("IO Example")
                                .version("1.0.0")
                )
                .servers(List.of(server));
    }

    @Bean
    public GroupedOpenApi allApiGroup() {
        return GroupedOpenApi.builder()
                .group("All")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi booksApiGroup() {
        return GroupedOpenApi.builder()
                .group("Books")
                .pathsToMatch("/books/**")
                .build();
    }
}
