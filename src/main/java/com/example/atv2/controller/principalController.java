package com.example.atv2.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class principalController {
    @FXML
    private BorderPane root;

    @FXML
    public void initialize(){
        carregarTela("principal-view.fxml");
    }

    @FXML
    public void abrirMain() {
        carregarTela("principal-view.fxml");
    }
    @FXML
    public void abrirCadastro() {
        carregarTela("CadClientes-view.fxml");
    }
    @FXML
    public void abrirProdutos() {
        carregarTela("Produtos-view.fxml");
    }

    private void carregarTela(String fxml) {
        try {
            root.setCenter(
                    FXMLLoader.load(getClass().getResource("/fxml/" + fxml))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}