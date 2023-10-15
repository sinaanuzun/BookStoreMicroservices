package com.example.bookservice.dto.request;

import lombok.Data;

@Data
public class CreateBookRequest {

    private String title;

    private String authorName;

    private String pressName;

    private int bookYear;
}
