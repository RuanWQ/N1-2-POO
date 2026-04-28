package org.example;

public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro emprestado :)");
        } else {
            System.out.println("Livro já está em uso :(");
        }
    }

    public void devolver() {
        disponivel = true;
        System.out.println("Livro devolvido ");
    }

    public String getTitulo() {
        return titulo;
    }

    public void mostrarInfo() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Disponivel: " + (disponivel ? "sim" : "não"));
    }
}