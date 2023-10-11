package com.example.bookservice.service;

import com.example.bookservice.dto.BookDto;
import com.example.bookservice.dto.BookIdDto;
import com.example.bookservice.exception.BookNotFoundException;
import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;


    public List<BookDto> getAllBooks(){
            return bookRepository.findAll()
                    .stream()
                    .map(book -> modelMapper.map(book, BookDto.class))
                    .collect(Collectors.toList());
    }


    public BookIdDto findByBookYear(int id){
        Book book = bookRepository.getBookByBookYear(id)
                .orElseThrow(() -> new BookNotFoundException("Id bulunamadı : " + id));
        return modelMapper.map(book,BookIdDto.class);
    }

    public BookDto findById(String id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Id bulunamadı : " + id));
        return modelMapper.map(book,BookDto.class);
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }



}
