package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAO {
    public void salvarLivro(String titulo, String autor) throws SQLException {
        String sql = "INSERT INTO livros (titulo, autor) VALUES (?, ?)";
        try (PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, titulo);
            pstmt.setString(2, autor);
            pstmt.executeUpdate();
        }
    }

    public List<String> listarLivros() throws SQLException {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT * FROM livros";
        try (ResultSet rs = DatabaseConfig.getConnection().createStatement().executeQuery(sql)) {
            while (rs.next()) {
                String status = rs.getInt("disponivel") == 1 ? "[Disponível]" : "[Emprestado]";
                lista.add(rs.getInt("id") + " - " + rs.getString("titulo") + " " + status);
            }
        }
        return lista;
    }

    public void emprestarLivro(int id) throws SQLException {
        String sql = "UPDATE livros SET disponivel = 0 WHERE id = ?";
        try (PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}