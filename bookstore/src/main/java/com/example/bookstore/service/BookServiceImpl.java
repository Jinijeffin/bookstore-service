package com.example.bookstore.service;
import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.dto.BookResponseDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    public BookRepository bookRepository;

   public BookResponseDto createBook(BookRequestDto dto){
        Book book = BookMapper.toEntity(dto);
        Book savedBook = bookRepository.save(book);
        return BookMapper.toResponseDto(book);

    }
    public List<BookResponseDto> getAllBooks(){
        List<Book> books =bookRepository.findAll();
        return books.stream()
        .map(BookMapper::toResponseDto)
        .collect(Collectors.toList());
    }
    public BookResponseDto getBookById(Long id){
        Book book = bookRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Book not found"));
        return BookMapper.toResponseDto(book);
    }
    public BookResponseDto updateBook(Long id, BookRequestDto dto){
        Book book = bookRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Book not found"));
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        book = bookRepository.save(book);
        return BookMapper.toResponseDto(book); 
    }
    public void deleteBook(Long id){
        Book book = bookRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Book not found"));
        bookRepository.delete(book);    
    }
}