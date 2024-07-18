package com.amsidh.mvc.controller;

import com.amsidh.mvc.entity.Author;
import com.amsidh.mvc.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/authors")
@Slf4j
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        // For each book, set the author reference
        author.getBooks().forEach(book -> book.setAuthor(author));
        return authorService.saveAuthor(author);
    }
}
