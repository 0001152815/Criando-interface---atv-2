package com.example.atv2.controller;

import com.example.atv2.dao.ProdutosDAO;
import com.example.atv2.model.Produtos;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;



public class produtosController {
    @FXML private TextField txtNome;
    @FXML private TextField txtPreco;
    @FXML private TableView<Produtos> tabelaProdutos ;
    @FXML private TableColumn<Produtos, Integer> colId;
    @FXML private TableColumn<Produtos, String> colNome;
    @FXML private TableColumn<Produtos, Double> colPreco;

    private ProdutosDAO dao = new ProdutosDAO();

    private Produtos produtoSelecionado;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        atualizarTabela();
    }
    private void atualizarTabela() {
        try {
            tabelaProdutos.setItems(FXCollections.observableArrayList(dao.listarTodos()));
        } catch (Exception e) { e.printStackTrace(); }
    }
    @FXML
    public void salvarProduto() {
        try {
            if (produtoSelecionado == null) {
                dao.salvar(new Produtos(txtNome.getText(), Double.parseDouble((txtPreco.getText()))));
            } else {
                produtoSelecionado.setNome(txtNome.getText());
                produtoSelecionado.setPreco(Double.parseDouble((txtPreco.getText())));
                dao.atualizar(produtoSelecionado);
            }
            atualizarTabela();
            limparCampos();
        } catch (Exception e) { exibirAlerta("erro", e.getMessage()); }
    }

    @FXML
    public void excluirProduto() {
        if (produtoSelecionado != null) {
            try {
                dao.excluir(produtoSelecionado.getId());
                atualizarTabela();
                limparCampos();
            } catch (Exception e) { exibirAlerta("erro", e.getMessage()); }
        }
    }
    @FXML
    public void selecionarItem() {
        produtoSelecionado = tabelaProdutos.getSelectionModel().getSelectedItem();
        if (produtoSelecionado != null) {
            txtNome.setText(produtoSelecionado.getNome());
            txtPreco.setText(String.valueOf(produtoSelecionado.getPreco()));
        }
    }
    @FXML
    public void limparCampos() {
        txtNome.clear();
        txtPreco.clear();
        produtoSelecionado = null;
        tabelaProdutos.getSelectionModel().clearSelection();
    }

    private void exibirAlerta(String titulo, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(msg);
        alert.show();
    }
}
