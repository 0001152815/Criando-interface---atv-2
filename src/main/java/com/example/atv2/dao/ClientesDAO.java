package com.example.atv2.dao;

import com.example.atv2.model.Clientes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {
    private Connection connection;

    public ClientesDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Clientes clientes) throws SQLException {
        String sql = "INSERT INTO clientes (nome, estado, email, senha) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, clientes.getNome());
            stmt.setString(2, clientes.getEstado());
            stmt.setString(3, clientes.getEmail());
            stmt.setString(4, clientes.getSenha());
            stmt.execute();
        }
    }

    public List<Clientes> listarTodos() throws SQLException {
        List<Clientes> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Clientes c = new Clientes();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEstado(rs.getString("estado"));
                c.setEmail(rs.getString("email"));
                c.setSenha(rs.getString("senha"));
                clientes.add(c);
            }
        }
        return clientes;
    }

    public void atualizar(Clientes clientes) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, estado = ?, email = ?, senha = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, clientes.getNome());
            stmt.setString(2,clientes.getEstado());
            stmt.setString(3, clientes.getEmail());
            stmt.setString(4, clientes.getSenha());
            stmt.setInt(3, clientes.getId());
            stmt.execute();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,id);
            stmt.execute();
        }
    }
}




