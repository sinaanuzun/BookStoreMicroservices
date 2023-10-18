package com.example.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private BookIdDto id;
    private String title;
    private Integer year;
    private String author;
    private String pressName;
}
