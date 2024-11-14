package com.alexmonzon.Logic;

import com.alexmonzon.Models.Book;
import com.alexmonzon.Persistence.MemoryBookRepository;
import com.alexmonzon.Persistence.MySQLBookRepository;

import java.util.List;
import java.util.Optional;

public class BookManager {

    private BookRepository bookRepository;

    public BookManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void CreateLibro(String isbn, String title, String author) {

        Optional<Book> opionalBook = bookRepository.findLibrobyIsbn(isbn);

        if (opionalBook.isPresent()) {
            throw new IllegalArgumentException("Este libro ya existe o el ISBN no es valido");
        }
        Book newBook = new Book(isbn, title, author);
        bookRepository.createBook(newBook);
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

    public void changeRepository(BookRepository newRepository){
        this.bookRepository = newRepository;
    }


}


