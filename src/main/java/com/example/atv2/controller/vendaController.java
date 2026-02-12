package com.example.atv2.controller;

import com.example.atv2.dao.VendaDAO;
import com.example.atv2.model.Produtos;
import com.example.atv2.model.Venda;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class vendaController {
    @FXML private TextField txtNome;
    @FXML private TextField txtPreco;
    @FXML private TextField txtQtd;
    @FXML private TableView<Venda> tabelaProdutos;
    @FXML private TableColumn<Venda, Integer> colId;
    @FXML private TableColumn<Venda, String> colNome;
    @FXML private TableColumn<Venda, Double> colPreco;
    @FXML private TableColumn<Venda, Integer> colQtd;

    private VendaDAO dao = new VendaDAO();

    private Venda produtoSeleionado;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colQtd.setCellValueFactory(new PropertyValueFactory<>("qtd"));
    }
    private void atualizarTabela() {
        try {
            tabelaProdutos.setItems(FXCollections.observableArrayList(dao.listarTodos()));
        } catch (Exception e) { e.printStackTrace(); }
    }
    @FXML
    public void excluirProduto() {
        if (produtoSeleionado != null) {
            try {
                dao.excluir(produtoSeleionado.getId());
                atualizarTabela();
                limparCampos();
            } catch (Exception e) { exibirAlerta("erro", e.getMessage()); }
        }
    }
    @FXML
    public void selecionarItem() {
        produtoSeleionado = tabelaProdutos.getSelectionModel().getSelectedItem();
        if (produtoSeleionado != null) {
            txtNome.setText(produtoSeleionado.getNome());
            txtQtd.setText(String.valueOf(produtoSeleionado.getPreco()));
            txtPreco.setText(String.valueOf(produtoSeleionado.getPreco()));
        }
    }

    @FXML
    public void salvarVenda() {
        try {
            String nome = txtNome.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            int qtd = Integer.parseInt(txtQtd.getText());

            if (nome.isEmpty()) {
                exibirAlerta("Erro", "O nome não pode estar vazio.");
                return;
            }

            Venda venda = new Venda();
            venda.setNome(nome);
            venda.setPreco(preco);
            venda.setQtd(qtd);

            dao.salvar(venda);  // método do DAO

            atualizarTabela();
            limparCampos();

        } catch (NumberFormatException e) {
            exibirAlerta("Erro", "Preço e Quantidade devem ser números válidos.");
        } catch (Exception e) {
            exibirAlerta("Erro", e.getMessage());
        }
    }

    @FXML
    public void limparCampos() {
        txtQtd.clear();
        txtPreco.clear();
        txtNome.clear();
        produtoSeleionado = null;
        tabelaProdutos.getSelectionModel().clearSelection();
    }

    private void exibirAlerta(String titulo, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(msg);
        alert.show();
    }
}
