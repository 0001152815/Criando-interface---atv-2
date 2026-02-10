package com.example.atv2.model;

public class Clientes {
    private int id;
    private String nome;
    private String estado;
    private String email;
    private String senha;

    public Clientes() {}

    public String getEmail() {
        return this.email;
    }
    public String getSenha() {
        return this.senha;
    }
    public String getNome() {
        return nome;
    }
    public int getId() {
        return id;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
