package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class BibliotecaGUI extends JFrame {
    private BibliotecaDAO dao = new BibliotecaDAO();
    private JTextArea areaTexto = new JTextArea();

    public BibliotecaGUI() {
        setTitle("Sistema Biblioteca Dois Irmoes");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de Botões
        JPanel painelBotoes = new JPanel();
        JButton btnListar = new JButton("Listar de Livros");
        JButton btnCadastrar = new JButton("Novo Livro");
        JButton btnEmprestar = new JButton("Emprestar (ID)");

        painelBotoes.add(btnListar);
        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnEmprestar);

        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // Ações
        btnListar.addActionListener(e -> atualizarLista());

        btnCadastrar.addActionListener(e -> {
            String t = JOptionPane.showInputDialog("Titulo:");
            String a = JOptionPane.showInputDialog("Autor:");
            try {
                dao.salvarLivro(t, a);
                atualizarLista();
            } catch (SQLException ex) { ex.printStackTrace(); }
        });

        btnEmprestar.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Livro:"));
            try {
                dao.emprestarLivro(id);
                atualizarLista();
            } catch (SQLException ex) { ex.printStackTrace(); }
        });
    }

    private void atualizarLista() {
        try {
            areaTexto.setText("<> <> <> <> Livros <> <> <> <>\n");
            for (String s : dao.listarLivros()) {
                areaTexto.append(s + "\n");
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BibliotecaGUI().setVisible(true);
        });
    }
}