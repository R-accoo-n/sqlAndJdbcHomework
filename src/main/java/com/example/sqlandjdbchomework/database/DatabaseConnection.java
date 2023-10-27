package com.example.sqlandjdbchomework.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:h2:mem:test";
    private static final String DB_USER = "h2";
    private static final String DB_PASSWORD = "";

    public static void createTables() {
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = conn.createStatement();) {

            statement.execute("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255), email VARCHAR(255))");

            statement.execute("CREATE TABLE IF NOT EXISTS companies (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), address VARCHAR(255))");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
