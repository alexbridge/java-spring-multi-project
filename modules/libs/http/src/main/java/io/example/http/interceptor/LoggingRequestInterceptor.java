package io.example.http.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(
            HttpRequest request,
            byte[] body,
            ClientHttpRequestExecution execution
    ) throws IOException {
        traceRequest(request, body);
        var response = execution.execute(request, body);
        traceResponse(response);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) {
        log.info(
                "Request {} {}: {}",
                request.getMethod(),
                request.getURI(),
                new String(body, StandardCharsets.UTF_8)
        );
    }

    private void traceResponse(ClientHttpResponse response) throws IOException {
        log.info(
                " Response {}: {}",
                response.getHeaders().getValuesAsList(HttpHeaders.CONTENT_TYPE),
                new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8)
        );
    }

}
