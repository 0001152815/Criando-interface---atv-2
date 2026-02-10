package com.example.atv2.controller;

import com.example.atv2.dao.ClientesDAO;
import com.example.atv2.model.Clientes;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert;

public class ClientesController {
    @FXML private TextField txtNome;
    @FXML private TextField txtEmail;
    @FXML private TextField txtSenha;
    @FXML private TextField txtEstado;

    private ClientesDAO dao = new ClientesDAO();
    private Clientes clientesSelecionado;

    @FXML
    public void initialize() {
        limparCampos();
    }

    @FXML
    public void salvarClientes() {
        if (!camposValidos()) {
            mostrarAlerta("Preencha todos os campos obrigatórios.");
            return;
        }
        Clientes c = new Clientes();
        c.setNome(txtNome.getText());
        c.setNome(txtEmail.getText());
        c.setNome(txtSenha.getText());
        c.setNome(txtEstado.getText());

        try {
            dao.salvar(c);
            mostrarAlerta("Cliente salvo com sucesso!");
            limparCampos();
        } catch (Exception e) {
            mostrarAlerta("Erro ao salvar cliente.");
            e.printStackTrace();
        }
    }

    private boolean camposValidos() {
        return !txtNome.getText().isEmpty()
            && !txtEmail.getText().isEmpty()
            && !txtSenha.getText().isEmpty()
            && !txtEstado.getText().isEmpty();
    }

    private void mostrarAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void limparCampos() {
        txtNome.clear();
        txtEmail.clear();
        txtSenha.clear();
        txtEstado.clear();
    }




}
