package com.alexmonzon;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    List<Libro> listaLibros = new ArrayList<>(List.of(
            new Libro("A001", "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin"),
            new Libro("A002", "The Pragmatic Programmer: Your Journey to Mastery", "Andrew Hunt, David Thomas"),
            new Libro("A003", "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"),
            new Libro("A004", "Introduction to the Theory of Computation", "Michael Sipser"),
            new Libro("A005", "JavaScript: The Good Parts", "Douglas Crockford"),
            new Libro("A006", "Structure and Interpretation of Computer Programs", "Harold Abelson, Gerald Jay Sussman"),
            new Libro("A007", "Artificial Intelligence: A Modern Approach", "Stuart Russell, Peter Norvig"),
            new Libro("A008", "Python Crash Course: A Hands-On, Project-Based Introduction to Programming", "Eric Matthes"),
            new Libro("A009", "You Don’t Know JS: ES6 & Beyond", "Kyle Simpson"),
            new Libro("A010", "Head First Design Patterns", "Eric Freeman, Bert Bates, Kathy Sierra, Elisabeth Robson")
    ));

    public BookManager() {
    }

    public boolean ifExist(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return true;
            }
        }
        return false;
    }

    public boolean isbnValidation(String isbn) {
        if (!isbn.matches("^[A-Za-z]\\d{3}$")) {
            return false;
        }
        return true;
    }

    public void addBook(String isbn, String title, String author) {
        Libro newBook = new Libro(isbn, title, author);
        if (isbnValidation(isbn) && !ifExist(isbn)) {
            listaLibros.add(newBook);
        } else {
            throw new IllegalArgumentException("Este libro ya existe o el ISBN no es valido");
        }

    }

    public void deleteBook(String isbn) {
        if (ifExist(isbn) && isbnValidation(isbn)) {
            listaLibros.removeIf(libro -> libro.getIsbn().equalsIgnoreCase(isbn));
        } else {
            throw new IllegalArgumentException("No se encontró ningún libro con el ISBN especificado.");
        }
    }


}


