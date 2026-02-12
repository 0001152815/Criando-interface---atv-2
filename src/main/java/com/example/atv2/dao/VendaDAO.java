package com.example.atv2.dao;

import com.example.atv2.model.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    private Connection connection;

    public VendaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Venda venda) throws SQLException {
        String sql = "INSERT INTO venda (nome, preco, qtd) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, venda.getNome());
            stmt.setDouble(2, venda.getPreco());
            stmt.setInt(3, venda.getQtd());
            stmt.execute();
        }
    }

    public List<Venda> listarTodos() throws SQLException {
        List<Venda> venda = new ArrayList<>();
        String sql = "SELECT * FROM venda";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Venda v = new Venda();
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setPreco(rs.getDouble("preco"));
                v.setQtd(rs.getInt("qtd"));
                venda.add(v);
            }
        }
        return venda;
    }

    public void atualizar(Venda venda) throws SQLException {
        String sql = "UPDATE venda SET nome = ?, preco = ?, qtd = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, venda.getNome());
            stmt.setDouble(2, venda.getPreco());
            stmt.setInt(3, venda.getQtd());
            stmt.execute();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM venda WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}