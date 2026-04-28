package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        int opcao;
        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {

            System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Lista de Livros");
            System.out.println("3 - Alugar Livro");
            System.out.println("4 - Devolver Livro");
            System.out.println("0 - Sair");
            System.out.print("Qual a sua escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    biblioteca.adicionarLivro(new Livro(titulo, autor));
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.print("Digite o titulo: ");
                    Livro livroEmp = biblioteca.buscarLivro(sc.nextLine());

                    if (livroEmp != null) {
                        livroEmp.emprestar();
                    } else {
                        System.out.println("Livro indisponivel but");
                    }
                    break;

                case 4:
                    System.out.print("Digite o titulo: ");
                    Livro livroDev = biblioteca.buscarLivro(sc.nextLine());

                    if (livroDev != null) {
                        livroDev.devolver();
                    } else {
                        System.out.println("Esse livro não exista LOL :(");
                    }
                    break;

                case 0:
                    System.out.println("Saindo da Biblioteca Dois-Irmoes");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção não criada");
            }

            System.out.print("\nDeseja continuar ou quer sair s ou n: ");
            continuar = sc.nextLine();

            if (continuar.equalsIgnoreCase("n")) {
                System.out.println("Saindo do sistema...!");
            }
        }

        sc.close();
    }
}