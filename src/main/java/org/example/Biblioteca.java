package org.example;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro incluido na biblioteca Dois-irmoes");
    }

    public void listarLivros() {
        for (Livro l : livros) {
            l.mostrarInfo();
            System.out.println("==============================");
        }
    }

    public Livro buscarLivro(String titulo) {
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        return null;
    }
}