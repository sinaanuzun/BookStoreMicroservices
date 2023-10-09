package com.example.bookservice.controller;

import com.example.bookservice.dto.BookDto;
import com.example.bookservice.dto.BookIdDto;
import com.example.bookservice.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
@AllArgsConstructor
@Validated
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getAllBook(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/bookyear/{bookyear}")
    public ResponseEntity<BookIdDto> getBookYear(@PathVariable @NotEmpty int bookyear){
        return ResponseEntity.ok(bookService.findByBookYear(bookyear));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String id){
        return ResponseEntity.ok(bookService.findById(id));
    }
}
