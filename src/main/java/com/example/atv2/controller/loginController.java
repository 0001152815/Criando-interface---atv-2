package com.example.atv2.controller;

import com.example.atv2.dao.LoginDAO;
import com.example.atv2.model.Login;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;

public class loginController {

    @FXML private TextField txtEmail;
    @FXML private TextField txtSenha;



    @FXML
    private void entrar() {

        LoginDAO dao = new LoginDAO();
        boolean autenticado = dao.autenticar(
                txtEmail.getText(),
                txtSenha.getText()
        );

        if (autenticado) {
            mostrarAlerta("Sucesso - Login realizado com sucesso!");
        } else {
            mostrarAlerta("Erro - Email ou senha inválidos");
        }
    }

    @FXML
    private void limparCampos() {
        txtEmail.clear();
        txtSenha.clear();
    }


    private void mostrarAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
