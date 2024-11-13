package io.example.books.api;

import java.util.List;

import io.example.books.api.model.Book;
import io.example.books.api.model.SearchBooks;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/books")
public interface BooksApi {
    @PostExchange(
            value = "/search",
            contentType = MediaType.APPLICATION_JSON_VALUE,
            accept = MediaType.APPLICATION_JSON_VALUE
    )
    List<Book> searchBooks(@RequestBody SearchBooks searchBooks);

    @GetExchange(value = "/{id}", accept = MediaType.APPLICATION_JSON_VALUE)
    Book getBook(@PathVariable(name = "id") String id);
}
