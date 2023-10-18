package com.example.libraryservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Library {

    @Id
    private String id;
}
