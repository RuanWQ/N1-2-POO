package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== BIBLIOTECA DOIS IRMÕES ===");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Cadastrar Usuário");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Realizar Empréstimo");
            System.out.println("6 - Realizar Devolução");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String t = sc.nextLine();
                    System.out.print("Autor: ");
                    String a = sc.nextLine();
                    biblioteca.adicionarLivro(t, a);
                    System.out.println("Livro cadastrado!");
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    System.out.print("Nome do Usuário: ");
                    String nomeU = sc.nextLine();
                    biblioteca.adicionarUsuario(nomeU);
                    System.out.println("Usuário cadastrado!");
                    break;
                case 4:
                    biblioteca.listarUsuarios();
                    break;
                case 5:
                    System.out.print("ID do Livro: ");
                    int idL = sc.nextInt();
                    System.out.print("ID do Usuário: ");
                    int idU = sc.nextInt();
                    Livro lEmp = biblioteca.buscarLivroPorId(idL);
                    Usuario uEmp = biblioteca.buscarUsuarioPorId(idU);

                    if (lEmp != null && uEmp != null && lEmp.isDisponivel()) {
                        lEmp.emprestar();
                        System.out.println("Empréstimo de '" + lEmp.getTitulo() + "' para " + uEmp.getNome() + " realizado!");
                    } else {
                        System.out.println("Falha: Livro indisponível ou IDs incorretos.");
                    }
                    break;
                case 6:
                    System.out.print("ID do Livro para devolução: ");
                    int idDev = sc.nextInt();
                    Livro lDev = biblioteca.buscarLivroPorId(idDev);
                    if (lDev != null) {
                        lDev.devolver();
                        System.out.println("Devolução concluída!");
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}