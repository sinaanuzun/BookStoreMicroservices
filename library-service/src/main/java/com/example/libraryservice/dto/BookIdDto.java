package com.example.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookIdDto {

    private String bookId;
    private String isbn;
    public static BookIdDto convert(String id, String isbn) {
        return new BookIdDto(id, isbn);
    }
}

