package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/wgym";
        String user = "root";
        String password = "jovanovic2703";

        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
