package com.trackolap.library_catalog_management.service;

import com.trackolap.library_catalog_management.entity.Book;
import com.trackolap.library_catalog_management.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibService {

    @Autowired
    private LibraryRepository libraryRepository;

    public List<Book> getAllBooks() {
        return libraryRepository.getAll();
    }

    public List<Book> addBook(Book book) {
        libraryRepository.save(book);
        return getAllBooks();
    }

    public Book getByAuthor(String author) {
        Book book;
        try {
            book = libraryRepository.findByAuthor(author);
        }
        catch (Exception e) {
            book = new Book("No book found", "No book found", "No book found");
        }
         return book;
    }

    public List<Book> removeBook(String isbn) {
        libraryRepository.deleteById(isbn);
        return getAllBooks();
    }

    public Book getByTitle(String title) {
        Book book;
        try {
            book = libraryRepository.findByTitle(title);
        }
        catch (Exception e) {
            book = new Book("No book found", "No book found", "No book found");
        }
        return book;
    }
}
