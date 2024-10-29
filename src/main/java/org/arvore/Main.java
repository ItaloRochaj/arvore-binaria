package org.arvore;

import org.arvore.ArvoreBinaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir elemento");
            System.out.println("2. Exibir em ordem");
            System.out.println("3. Exibir em pré-ordem");
            System.out.println("4. Exibir em pós-ordem");
            System.out.println("5. Remover elemento");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite um elemento para inserir: ");
                    int elemento = scanner.nextInt();
                    arvore.inserir(elemento);
                    System.out.println("Elemento " + elemento + " inserido com sucesso.");
                    break;
                case 2:
                    arvore.exibirInOrdem();
                    break;
                case 3:
                    arvore.exibirPreOrdem();
                    break;
                case 4:
                    arvore.exibirPosOrdem();
                    break;
                case 5:
                    System.out.print("Digite um elemento para remover: ");
                    int elementoRemover = scanner.nextInt();
                    arvore.remover(elementoRemover);
                    System.out.println("Elemento " + elementoRemover + " removido.");
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 6);

        scanner.close();
    }
}
