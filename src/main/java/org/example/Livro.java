package org.example;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public boolean isDisponivel() { return disponivel; }

    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id + " | Titulo: " + titulo + " | Autor: " + autor + " | Status: " + (disponivel ? "Disponivel" : "Emprestado"));
    }
}