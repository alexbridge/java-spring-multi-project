package io.example.books.api.model;

import io.example.spring.commons.aspect.UpperSnakeCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements UpperSnakeCase {
    private String id;
    private String bookTitle;
}
