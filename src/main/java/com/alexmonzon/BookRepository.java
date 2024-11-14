package com.alexmonzon;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void createBook(Book book);

    List<Book> findAll();

    void updateLibro(Book book);

    Optional<Book> findLibrobyIsbn(String isbn);

    void deleteLibrobyIsbn(String isbn);
}
