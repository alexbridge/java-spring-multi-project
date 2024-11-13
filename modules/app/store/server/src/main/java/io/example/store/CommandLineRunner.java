package io.example.store;

import io.example.books.api.BooksApi;
import io.example.books.api.BooksApiConfiguration;
import io.example.books.api.model.SearchBooks;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@Import(BooksApiConfiguration.class)
public class CommandLineRunner {
    private final BooksApi booksApi;

    @SneakyThrows
    @PostConstruct
    void searchBooks() {

        var books = booksApi.searchBooks(new SearchBooks("foo"));

        log.info("Found {} books: {}", books.size(), books);

        var book = booksApi.getBook("100");

        log.info("Book 100: {}", book);

    }
}
