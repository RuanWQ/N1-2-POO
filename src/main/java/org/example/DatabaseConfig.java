package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {
    private static final String URL = "jdbc:sqlite:biblioteca.db";

    public static Connection getConnection() throws SQLException {
        try {
            // Força o carregamento do driver
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver não encontrado!");
        }
        return DriverManager.getConnection(URL);
    }

    public static void criarTabelas() {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS livros (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT NOT NULL," +
                    "autor TEXT NOT NULL," +
                    "disponivel INTEGER DEFAULT 1)");

            stmt.execute("CREATE TABLE IF NOT EXISTS usuarios (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT NOT NULL)");

            stmt.execute("INSERT OR IGNORE INTO livros (id, titulo, autor, disponivel) VALUES " +
                    "(1, 'Dom Casmurro', 'Machado de Assis', 1)," +
                    "(2, 'A Hora da Estrela', 'Clarice Lispector', 1)," +
                    "(3, 'O Alquimista', 'Paulo Coelho', 1)," +
                    "(4, 'Capitães da Areia', 'Jorge Amado', 1)," +
                    "(5, 'Memórias Postumas', 'Machado de Assis', 1)");

            System.out.println("Banco de dados inicializado com 5 livros padrão.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}