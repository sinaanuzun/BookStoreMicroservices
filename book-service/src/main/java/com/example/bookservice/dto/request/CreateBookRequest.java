package com.example.bookservice.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateBookRequest {

    @NotBlank
    private String title;

    private String authorName;

    private String pressName;

    private int bookYear;
}
