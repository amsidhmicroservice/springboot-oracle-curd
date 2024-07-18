package com.amsidh.mvc;

import com.amsidh.mvc.entity.Author;
import com.amsidh.mvc.entity.Book;
import com.amsidh.mvc.repository.AuthorRepository;
import com.amsidh.mvc.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
@Slf4j
public class SpringbootOracleCurdApplication implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootOracleCurdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Author author = Author.builder().name("Amsidh").build();
        Book book1 = Book.builder().title("Java Programming 1").author(author).build();
        Book book2 = Book.builder().title("Java Programing 2").author(author).build();
        Book book3 = Book.builder().title("Java Programing 3").author(author).build();
        Book book4 = Book.builder().title("Java Programing 4").author(author).build();
        authorRepository.save(author);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);

    }
}
