package com.alexmonzon;

import java.util.List;
import java.util.Optional;

public class BookManager {

    private MySQLBookRepository bookRepository;

    public BookManager() {
    this.bookRepository = new MySQLBookRepository();
    }

    public boolean isbnValidation(String isbn) {
        if (!isbn.matches("^[A-Za-z]\\d{3}$")) {
            return false;
        }
        return true;
    }

    public void CreateLibro(String isbn, String title, String author) {

        Optional<Book> opionalBook = bookRepository.findLibrobyIsbn(isbn);
        Book newBook = new Book(isbn, title, author);
        if (opionalBook.isPresent()) {
            throw new IllegalArgumentException("Este libro ya existe o el ISBN no es valido");
        }
        Book newLibro = new Book(isbn, title, author);
        bookRepository.createBook(newLibro);
    }

    public void deleteBook(String isbn) {
        Optional<Book> opionalBook = bookRepository.findLibrobyIsbn(isbn);

        if (opionalBook.isPresent()) {
            bookRepository.deleteLibrobyIsbn(isbn);
        }
        throw new IllegalArgumentException("No se encontró ningún libro con el ISBN especificado.");

    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }


}


