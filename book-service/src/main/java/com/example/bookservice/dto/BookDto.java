package com.example.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private int id;

    private String title;

    private String authorName;

    private String pressName;

    private int bookYear;

}
