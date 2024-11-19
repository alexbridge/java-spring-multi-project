package io.example.books.api.books;

import io.example.books.api.BooksApi;
import io.example.books.api.model.Book;
import io.example.books.api.model.SearchBooks;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Books API")
public class BooksController implements BooksApi {
    @Override
    @ResponseBody
    @ApiResponse(responseCode = "200", description = "Books")
    public List<Book> searchBooks(@RequestBody SearchBooks searchBooks) {
        return List.of(
                new Book(
                        "1",
                        "Book %s".formatted(
                                Optional.ofNullable(searchBooks.getName())
                                        .orElse("name")
                        ))
        );
    }

    @Override
    @ResponseBody
    @ApiResponse(responseCode = "200", description = "Book")
    public Book getBook(String id) {
        return new Book(id, "Book with id %s".formatted(id));
    }
}
