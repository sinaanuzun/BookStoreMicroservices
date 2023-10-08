package com.example.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookIdDto {

    private String id;

    private int bookYear;

    private String isbn;

//    public BookIdDto(String id, int bookYear) {
//        this.id = id;
//        this.bookYear = bookYear;
//    }
//
//    public static BookIdDto convert(String id, int bookYear, String isbn){
//        return new BookIdDto(id,bookYear,isbn);
//    }
}
