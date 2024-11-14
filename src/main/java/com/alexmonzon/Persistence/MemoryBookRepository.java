package com.alexmonzon.Persistence;

import com.alexmonzon.Logic.BookRepository;
import com.alexmonzon.Models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryBookRepository implements BookRepository {

    private static List<Book> listaBooks = new ArrayList<>(List.of(
            new Book("A001", "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin"),
            new Book("A002", "The Pragmatic Programmer: Your Journey to Mastery", "Andrew Hunt, David Thomas"),
            new Book("A003", "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"),
            new Book("A004", "Introduction to the Theory of Computation", "Michael Sipser"),
            new Book("A005", "JavaScript: The Good Parts", "Douglas Crockford"),
            new Book("A006", "Structure and Interpretation of Computer Programs", "Harold Abelson, Gerald Jay Sussman"),
            new Book("A007", "Artificial Intelligence: A Modern Approach", "Stuart Russell, Peter Norvig"),
            new Book("A008", "Python Crash Course: A Hands-On, Project-Based Introduction to Programming", "Eric Matthes"),
            new Book("A009", "You Don’t Know JS: ES6 & Beyond", "Kyle Simpson"),
            new Book("A010", "Head First Design Patterns", "Eric Freeman, Bert Bates, Kathy Sierra, Elisabeth Robson")
    ));

    @Override
    public void createBook(Book book) {
        listaBooks.add(book);
    }

    @Override
    public List<Book> findAll() {
        return listaBooks;
    }

    @Override
    public void updateLibro(Book book) {

    }

    @Override
    public Optional<Book> findLibrobyIsbn(String isbn) {
        for (Book book : listaBooks) {
            if (book.getIsbn().equals(isbn)) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    @Override
    public void deleteLibrobyIsbn(String isbn) {
        listaBooks.removeIf(libro -> libro.getIsbn().equals(isbn));
    }
}
