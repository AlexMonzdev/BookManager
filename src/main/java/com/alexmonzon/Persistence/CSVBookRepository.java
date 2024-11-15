package com.alexmonzon.Persistence;

import com.alexmonzon.Logic.BookRepository;
import com.alexmonzon.Models.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CSVBookRepository implements BookRepository {

    @Override
    public void createBook(Book book) {

        File file = new File("./prueba.csv");

        try(FileWriter fw = new FileWriter(file, true)) {
            fw.write(book.getIsbn() + ",");
            fw.write(book.getTitulo() + ",");
            fw.write(book.getAutor() + ",");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        File file = new File("./prueba.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 3) {
                    String isbn = parts[0].trim();
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    Book book = new Book(isbn, title, author);
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public void updateLibro(Book book) {

    }

    @Override
    public Optional<Book> findLibrobyIsbn(String isbn) {
        return Optional.empty();
    }

    @Override
    public void deleteLibrobyIsbn(String isbn) {

    }
}
