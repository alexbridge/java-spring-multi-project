package io.example.book.api;

import io.example.book.model.Book;
import io.example.book.model.SearchBooks;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Books API")
public class BooksController implements BooksApi {
    @Override
    @ApiResponse(responseCode = "200", description = "Books")
    public List<Book> searchBooks(@RequestBody SearchBooks searchBooks) {
        return List.of(
                new Book("Book %s".formatted(
                        Optional.ofNullable(searchBooks.getName())
                                .orElse("name")
                ))
        );
    }

    @Override
    @ApiResponse(responseCode = "200", description = "Book")
    public Book getBook(String id) {
        return new Book("Book with id %s".formatted(id));
    }
}
