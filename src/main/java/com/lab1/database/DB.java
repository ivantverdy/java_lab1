package com.lab1.database;

import java.sql.*;

public class DB {
    private static final String url = "jdbc:postgresql://localhost:5432/stones";
    private static final String user = "postgres";
    private static final String password = "123123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
