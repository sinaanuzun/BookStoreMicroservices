package com.example.bookservice.controller;

import com.example.bookservice.dto.BookDto;
import com.example.bookservice.dto.BookIdDto;
import com.example.bookservice.dto.request.CreateBookRequest;
import com.example.bookservice.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getAllBook(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/bookyear/{bookyear}")
    public ResponseEntity<List<BookIdDto>> getBooksByYear(@PathVariable @NotEmpty int bookyear) {
        return ResponseEntity.ok(bookService.findByBookYear(bookyear));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BookDto> save(@RequestBody @Valid CreateBookRequest request){
        return ResponseEntity.ok(bookService.saveBook(request));
    }

}