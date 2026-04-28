package org.example;

public class Usuario {
    private int id;
    private String nome;

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }

    public void mostrarInfo() {
        System.out.println("ID: " + id + " | Nome: " + nome);
    }
}