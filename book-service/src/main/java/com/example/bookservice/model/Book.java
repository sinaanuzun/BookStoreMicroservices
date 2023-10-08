package com.example.bookservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@RequiredArgsConstructor
@ToString
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String title;

    private String authorName;

    private String pressName;

    private int bookYear;

    private String isbn;
}
