package com.amsidh.mvc.service;

import com.amsidh.mvc.entity.Author;

import java.util.List;

public interface AuthorService {
    Author saveAuthor(Author author);
    List<Author> getAllAuthors();

}
