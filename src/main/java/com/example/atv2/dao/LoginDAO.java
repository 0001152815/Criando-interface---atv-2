package com.example.atv2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public boolean autenticar(String email, String senha) {
        String sql = "SELECT 1 FROM login WHERE email = ? AND senha = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao autenticar usuário", e);
        }
    }
}
