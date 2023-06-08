package com.trackolap.library_catalog_management.repository;

import com.trackolap.library_catalog_management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

/** this will be our repository
 *  the LibraryCatalog class
 */
public interface LibraryRepository extends JpaRepository<Book, String> {

    Book findByAuthor(String author);

    Book findByTitle(String title);

    @Query(value = "SELECT * FROM BOOK", nativeQuery = true)
    List<Book> getAll();

    void deleteByIsbn(String isbn);


}
