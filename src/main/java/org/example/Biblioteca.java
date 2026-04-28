package org.example;

import java.sql.*;

public class Biblioteca {

    public void adicionarLivro(String titulo, String autor) {
        String sql = "INSERT INTO livros (titulo, autor, disponivel) VALUES (?, ?, 1)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, titulo);
            pstmt.setString(2, autor);
            pstmt.executeUpdate();
            System.out.println("Livro incluído com sucesso :)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarUsuario(String nome) {
        String sql = "INSERT INTO usuarios (nome) VALUES (?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso :)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarLivros() {
        String sql = "SELECT * FROM livros";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n<> <> <> <> ACERVO DA BIBLIOTECA <> <> <> <>");
            while (rs.next()) {
                String status = (rs.getInt("disponivel") == 1) ? "Disponivel" : "Emprestado";
                System.out.println("ID: " + rs.getInt("id") +
                        " | Título: " + rs.getString("titulo") +
                        " | Autor: " + rs.getString("autor") +
                        " | Status: " + status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n<> <> <> <> USUARIOS CADASTRADOS <> <> <> <>");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Nome: " + rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Livro buscarLivroPorId(int id) {
        String sql = "SELECT * FROM livros WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Livro l = new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"));
                if (rs.getInt("disponivel") == 0) {
                    l.emprestar();
                }
                return l;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Usuario buscarUsuarioPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizarStatusBD(int idLivro, int status) {
        String sql = "UPDATE livros SET disponivel = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, status);
            pstmt.setInt(2, idLivro);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar status no banco: " + e.getMessage());
        }
    }
}