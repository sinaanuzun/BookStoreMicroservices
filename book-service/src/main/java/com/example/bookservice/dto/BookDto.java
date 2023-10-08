package com.example.bookservice.dto;

import com.example.bookservice.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private BookIdDto id;

    private String title;

    private String authorName;

    private String pressName;

    private int bookYear;

    private String isbn;

    public static BookDto convert(Book from){
        BookIdDto idDto = null;
        if(from.getId() !=null){
            idDto = BookIdDto.convert(from.getId(), from.getBookYear(), from.getIsbn());
        }

        return new BookDto(
                idDto,
                from.getTitle(),
                from.getAuthorName(),
                from.getPressName(),
                from.getBookYear(),
                from.getIsbn()
        );
    }


}
