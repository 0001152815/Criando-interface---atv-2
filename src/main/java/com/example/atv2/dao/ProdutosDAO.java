package com.example.atv2.dao;
import com.example.atv2.model.Produtos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    private Connection connection;

    public ProdutosDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Produtos produto) throws SQLException {
        String sql = "INSERT INTO produtos (nome, preco) VALUES (?,? )";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1,produto.getNome());
            stmt.setDouble(2,produto.getPreco());
            stmt.execute();
        }
    }

    public List<Produtos> listarTodos() throws SQLException {
        List<Produtos> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produtos p = new Produtos();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                produtos.add(p);
            }
        }
        return produtos;

    }
    public void atualizar(Produtos produto) throws SQLException {
        String sql = "UPDATE produtos SET nome = ?, preco = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
