package com.example.atv2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/atv02"; // Endereço, porta e nome do banco.
    private static final String USER = "root"; // Usuário do banco.
    private static final String PASSWORD = ""; // Senha do banco.

     static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {

            throw new RuntimeException("Erro ao conectar: " + e.getMessage());
        }
    }

}
