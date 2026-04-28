package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseConfig.criarTabelas();
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n<> <> <> <> BIBLIOTECA DOIS IRMÕES <> <> <> <>");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Cadastrar Usuario");
            System.out.println("4 - Listar Usuarios");
            System.out.println("5 - Realizar Emprestimo");
            System.out.println("6 - Realizar Devolução");
            System.out.println("7 - ABRIR INTERFACE GRAFICA");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Titulo: ");
                    String t = sc.nextLine();
                    System.out.print("Autor: ");
                    String a = sc.nextLine();
                    biblioteca.adicionarLivro(t, a);
                    System.out.println("Livro cadastrado!");
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 5:
                    System.out.print("ID do Livro: ");
                    int idL = sc.nextInt();
                    System.out.print("ID do Usuario: ");
                    int idU = sc.nextInt();
                    Livro lEmp = biblioteca.buscarLivroPorId(idL);
                    Usuario uEmp = biblioteca.buscarUsuarioPorId(idU);

                    if (lEmp != null && uEmp != null && lEmp.isDisponivel()) {
                        biblioteca.atualizarStatusBD(idL, 0);
                        System.out.println("Emprestimo de '" + lEmp.getTitulo() + "' para " + uEmp.getNome() + " realizado!");
                    } else {
                        System.out.println(":( Livro ocupado ou não existe ):");
                    }
                    break;
                case 6:
                    System.out.print("ID do Livro para devolução: ");
                    int idDev = sc.nextInt();
                    Livro lDev = biblioteca.buscarLivroPorId(idDev);
                    if (lDev != null) {
                        biblioteca.atualizarStatusBD(idDev, 1);
                        System.out.println("Devolução concluída :)");
                    } else {
                        System.out.println("Livro não encontrado :(");
                    }
                    break;
                case 7:
                    System.out.println("Abrindo a tela:) :) :)");
                    // Chama a classe GUI que você criou
                    new BibliotecaGUI().setVisible(true);
                    break;
                case 0:
                    System.out.println("Saindo...!!!");
                    break;
            }
        }
        sc.close();
    }
}