package storeManager;

import java.util.Scanner;

public class MenuVendedor {
    private GerenciamentoVenda gerenciamentoVenda;
    private Vendedor vendedorLogado;
    private GerenciamentoEstoque gerenciamentoEstoque;

    public MenuVendedor(GerenciamentoVenda gerenciamentoVenda, Vendedor vendedorLogado, GerenciamentoEstoque gerenciamentoEstoque) {
        this.gerenciamentoEstoque = gerenciamentoEstoque;
        this.gerenciamentoVenda = gerenciamentoVenda;
        this.vendedorLogado = vendedorLogado;
    }

    public void exibirMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--------- Menu do Vendedor ---------\n");
            System.out.println("1. Iniciar Nova Venda");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Ver Comissão");
            System.out.println("4. Sair");
            System.out.print("\nEscolha uma opção: ");

            int opcao;
            while (true) {
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer após a leitura
                    break;
                } else {
                	System.out.println("\n---------------------------------------------");
                    System.out.println("Entrada inválida! Digite um número válido.");
                    System.out.println("---------------------------------------------");
                    scanner.nextLine(); // Descarta a entrada inválida
                    System.out.print("\nEscolha uma opção: ");
                }
            }

            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println("Nova Venda Iniciada\n");
                    gerenciamentoVenda.iniciarVenda(scanner);
                    break;
                case 2:
                    gerenciamentoEstoque.listarProdutos();
                    break;
                case 3:
                    if (vendedorLogado.getComissao() == 0) {
                        System.out.println("---------------------------------");
                        System.out.println("Nenhuma comissão acumulada ainda.");
                        System.out.println("---------------------------------");
                    } else {
                        System.out.println("-------------------------------");
                        System.out.printf("Comissão acumulada: R$ %.2f%n", vendedorLogado.getComissao());
                        System.out.println("-------------------------------");
                    }
                    break;
                case 4:
                    System.out.println("----------------------------------------------");
                    System.out.println("Sessão encerrada. Obrigado por usar o sistema!");
                    System.out.println("----------------------------------------------");
                    return; // Encerra o menu corretamente
                default:
                    System.out.println("------------------");
                    System.out.println("Opção inválida!");
                    System.out.println("------------------");
                    break;
            }
        }
    }
}
