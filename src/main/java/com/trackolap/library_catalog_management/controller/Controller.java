package com.trackolap.library_catalog_management.controller;

import com.trackolap.library_catalog_management.entity.Book;
import com.trackolap.library_catalog_management.service.LibService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

@RestController(value = "/library_catalog")
public class Controller {

    @Autowired
    private LibService service;

    @GetMapping (value = "/listAll")
    public List<Book> displayAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping(value = "/searchByTitle")
    public Book searchByTitle (@RequestParam String title) {
        return service.getByTitle(title);
    }
    @GetMapping(value = "/searchByAuthor")
    public Book searchByAuthor (@RequestParam String author) {
        return service.getByAuthor(author);
    }

    @PostMapping(value = "/addBook")
    public List<Book> addBook (@RequestParam Book book) {
        return service.addBook(book);
    }

    @GetMapping(value = "/removeBook")
    public List<Book> deleteBook (@RequestParam String isbn) {
        return service.removeBook(isbn);
    }

}
