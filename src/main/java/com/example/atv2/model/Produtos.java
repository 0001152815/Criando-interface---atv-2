package com.example.atv2.model;

public class Produtos {
    private String nome;
    private double preco;
    private int id;

    public Produtos() {

    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produtos(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }




}
