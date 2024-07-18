package com.amsidh.mvc.service;

import com.amsidh.mvc.entity.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    List<Book> getAllBooks();
}
