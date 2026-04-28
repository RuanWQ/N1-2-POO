package org.example;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private int proximoLivroId = 1;
    private int proximoUsuarioId = 1;

    public Biblioteca() {
        popularDadosIniciais();
    }

    private void popularDadosIniciais() {
        adicionarLivro("Dom Casmurro", "Machado de Assis");
        adicionarLivro("1984", "George Orwell");
        adicionarLivro("O Pequeno Príncipe", "Antoine de Saint-Exupéry");
        adicionarLivro("O Hobbit", "J.R.R. Tolkien");
    }

    public void adicionarLivro(String titulo, String autor) {
        livros.add(new Livro(proximoLivroId++, titulo, autor));
    }

    public void adicionarUsuario(String nome) {
        usuarios.add(new Usuario(proximoUsuarioId++, nome));
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Acervo vazio.");
            return;
        }
        for (Livro l : livros) l.mostrarInfo();
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        for (Usuario u : usuarios) u.mostrarInfo();
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro l : livros) {
            if (l.getId() == id) return l;
        }
        return null;
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }
}