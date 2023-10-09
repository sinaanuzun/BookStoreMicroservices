package com.example.bookservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
