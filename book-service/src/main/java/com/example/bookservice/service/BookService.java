package com.example.bookservice.service;

import com.example.bookservice.dto.BookDto;
import com.example.bookservice.dto.BookIdDto;
import com.example.bookservice.dto.request.CreateBookRequest;
import com.example.bookservice.exception.book.BookNotFoundException;
import com.example.bookservice.exception.book.BookNotSavedException;
import com.example.bookservice.exception.book.IdNotFoundException;
import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
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



    public List<BookIdDto> findByBookYear(int year) {
        List<Book> books = bookRepository.findByBookYear(year);
        if (books.isEmpty()) {
            throw new BookNotFoundException("Belirtilen yıla ait kitap bulunamadı : " + year);
        }
        return books.stream()
                .map(book -> modelMapper.map(book, BookIdDto.class))
                .collect(Collectors.toList());
    }


    public BookDto findById(String id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Belirtilen ID ye ait kitap bulunamadı: " + id));
        return modelMapper.map(book,BookDto.class);
    }

    @Transactional()
    public BookDto saveBook(CreateBookRequest request){
        try {
            Book book = modelMapper.map(request,Book.class);
            book = bookRepository.save(book);

            return modelMapper.map(book, BookDto.class);
        } catch (DataAccessException e){
            throw new BookNotSavedException("Kitap kaydedilmedi : " + request);
        }

    }


    @Transactional
    public void delete(String id){
         Book book = bookRepository.findById(id)
                 .orElseThrow(() -> new IdNotFoundException("Belirtilen ID ye ait kitap bulunamadı: " + id));
         bookRepository.delete(book);
    }


}
