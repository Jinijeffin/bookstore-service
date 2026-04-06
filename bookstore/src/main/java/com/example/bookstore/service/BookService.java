package com.example.bookstore.service;
import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.dto.BookResponseDto;
import java.util.List;

public interface BookService{
    BookResponseDto createBook(BookRequestDto dto);
    List<BookResponseDto> getAllBooks();
    BookResponseDto getBookById(Long id);
    BookResponseDto updateBook(Long id, BookRequestDto dto);
    void deleteBook(Long id);
}