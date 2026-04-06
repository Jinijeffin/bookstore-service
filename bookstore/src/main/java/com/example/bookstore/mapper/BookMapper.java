package com.example.bookstore.mapper;
import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.dto.BookResponseDto;
import com.example.bookstore.entity.Book;

public class BookMapper{

    public static Book toEntity(BookRequestDto dto){
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        return book;
      }
      public static BookResponseDto toResponseDto(Book book){
        BookResponseDto dto = new BookResponseDto();    
        dto.setId(book.getId());    
        dto.setTitle(book.getTitle());  
        dto.setAuthor(book.getAuthor());    
        dto.setPrice(book.getPrice());  
        return dto; 
      } 
}