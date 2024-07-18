package com.amsidh.mvc.controller;

import com.amsidh.mvc.entity.Book;
import com.amsidh.mvc.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
@Slf4j
public class BookController {
    private final BookService bookService;

    private final ObjectMapper objectMapper;

    @GetMapping
    public List<Book> getAllBooks() throws JsonProcessingException {
        final List<Book> allBooks = bookService.getAllBooks();
        log.info("All Books {}", objectMapper.writeValueAsString(allBooks));
        return allBooks;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
}
