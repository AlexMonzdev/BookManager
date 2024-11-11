package com.alexmonzon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryDAO {

    public void createBook(Libro libro) {
        String sql = "INSERT INTO libros (isbn, title, author) VALUES ('%s', '%s', '%s')"
                .formatted(libro.getIsbn(), libro.getTitulo(), libro.getAutor());
        System.out.println(sql);
        try {
            Connection connection = MySqlConexion.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Libro> getBooks() {
        List<Libro> lib = new ArrayList<>();
        String sql = "SELECT * from libros";
        try {
            Connection connection = MySqlConexion.getConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                lib.add(new Libro(res.getString("isbn"), res.getString("title"), res.getString("author")));
            }
            res.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lib;
    }

    public void updateLibro(Libro libro) {
        String sql = "UPDATE libros SET isbn = ?, title = ?, author = ? WHERE isbn = ?";
        try {
            Connection connection = MySqlConexion.getConnection();
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1, libro.getIsbn());
            stat.setString(2, libro.getTitulo());
            stat.setString(3, libro.getAutor());
            stat.setString(4, libro.getIsbn());
            stat.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateLibrobyIsbn(Libro libro, String isbn) {
        String sql = "UPDATE libros SET isbn = ?, title = ?, author = ? WHERE isbn = ?";
        try {
            Connection connection = MySqlConexion.getConnection();
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1, libro.getIsbn());
            stat.setString(2, libro.getTitulo());
            stat.setString(3, libro.getAutor());
            stat.setString(4, isbn);
            stat.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteLibrobyIsbn(String isbn) {
        String sql = "DELETE FROM libros WHERE isbn = ?";
        try {
            Connection connection = MySqlConexion.getConnection();
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1, isbn);
            stat.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
