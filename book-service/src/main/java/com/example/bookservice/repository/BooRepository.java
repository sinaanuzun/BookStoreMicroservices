package com.example.bookservice.repository;

import com.example.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooRepository extends JpaRepository<Book, String> {
}
