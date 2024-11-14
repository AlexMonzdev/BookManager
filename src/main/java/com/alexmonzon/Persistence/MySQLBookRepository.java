package com.alexmonzon.Persistence;

import com.alexmonzon.Logic.BookRepository;
import com.alexmonzon.Models.Book;
import com.alexmonzon.Config.MySqlConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySQLBookRepository implements BookRepository {


    @Override
    public void createBook(Book book) {
        String sql = "INSERT INTO libros (isbn, title, author) VALUES ('%s', '%s', '%s')"
                .formatted(book.getIsbn(), book.getTitulo(), book.getAutor());
        System.out.println(sql);
        try (Connection connection = MySqlConexion.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public List<Book> findAll() {
        List<Book> listaBooks = new ArrayList<>();
        String sql = "SELECT * from libros";
        try (Connection connection = MySqlConexion.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet res = statement.executeQuery(sql);

            while (res.next()) {
                listaBooks.add(new Book(res.getString("isbn"), res.getString("title"), res.getString("author")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listaBooks;
    }


    @Override
    public void updateLibro(Book book) {
        String sql = "UPDATE libros SET isbn = ?, title = ?, author = ? WHERE isbn = ?";
        
        try(Connection connection = MySqlConexion.getConnection();
            PreparedStatement stat = connection.prepareStatement(sql)){

            stat.setString(1, book.getIsbn());
            stat.setString(2, book.getTitulo());
            stat.setString(3, book.getAutor());
            stat.setString(4, book.getIsbn());
            stat.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public Optional<Book> findLibrobyIsbn(String isbn) {
        String sql = "Select * from libros WHERE isbn = '%s'".formatted(isbn);
        try (Connection connection = MySqlConexion.getConnection();
             Statement stat = connection.createStatement()){

            ResultSet res = stat.executeQuery(sql);

            if (res.next()) {
                Book book = new Book(res.getString("isbn"),
                                        res.getString("title"),
                                        res.getString("author"));
                return Optional.of(book);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
                return Optional.empty();
    }


    @Override
    public void deleteLibrobyIsbn(String isbn) {
        String sql = "DELETE FROM libros WHERE isbn = '%s'".formatted(isbn);
        try (Connection connection = MySqlConexion.getConnection();
             Statement stat = connection.createStatement()) {

            stat.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
