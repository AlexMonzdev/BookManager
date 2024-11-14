package com.alexmonzon.Config;

import java.sql.*;

public class MySqlConexion {

    static final String url = "jdbc:mysql://localhost:3306/books_db";
    static final String user = "root";
    static final String password = "";

    public static Connection getConnection() throws SQLException {
        System.out.println("Estoy conectado");
        return DriverManager.getConnection(url, user, password);
    }

}
