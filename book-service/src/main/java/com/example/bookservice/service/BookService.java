package com.example.bookservice.service;

import com.example.bookservice.dto.BookDto;
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


    List<BookDto> bookDtosDTOList(){
            return bookRepository.findAll()
                    .stream()
                    .map(source -> modelMapper.map(source, BookDto.class))
                    .collect(Collectors.toList());
    }


    public BookDto get(String id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Kitap bulunamadı.." + id));
        return modelMapper.map(book,BookDto.class);
    }



}
