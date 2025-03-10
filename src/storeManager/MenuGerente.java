package storeManager;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MenuGerente {
    private GerenciamentoEstoque gerenciamentoEstoque;
    private Estoque estoque;

    public MenuGerente(GerenciamentoEstoque gerenciamentoEstoque, Estoque estoque) {
        this.gerenciamentoEstoque = gerenciamentoEstoque;
        this.estoque = estoque;
    }

    public void exibirMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--------- Menu do Gerente ---------\n");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Remover Produto");
            System.out.println("3. Alterar Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Exibir Histórico de Vendas");
            System.out.println("6. Sair");
            System.out.print("\nEscolha uma opção: ");

            int opcao;
            while (true) {
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer após ler o número
                    break;
                } else {
                	System.out.println("\n------------------------------------------");
                    System.out.println("Entrada inválida! Digite um número válido.");
                    System.out.println("------------------------------------------");
                    scanner.nextLine(); // Descarta a entrada inválida
                    System.out.print("\nEscolha uma opção: ");
                }
            }

            System.out.println("");

            switch (opcao) {
                case 1:
                    gerenciamentoEstoque.adicionarProduto(scanner);
                    break;
                case 2:
                    gerenciamentoEstoque.removerProduto(scanner);
                    break;
                case 3:
                    gerenciamentoEstoque.alterarProduto(scanner);
                    break;
                case 4:
                    gerenciamentoEstoque.listarProdutos();
                    break;
                case 5:
                    exibirHistoricoVendas();
                    break;
                case 6:
                    System.out.println("----------------------------------------------");
                    System.out.println("Sessão encerrada. Obrigado por usar o sistema!");
                    System.out.println("----------------------------------------------");
                    return; // Sai do menu sem precisar do `break`
                default:
                	System.out.println("-----------------");
                    System.out.println("Opção inválida!");
                    System.out.println("-----------------");
                    break;
            }
        }
    }


    // Método para exibir o histórico de vendas
    private void exibirHistoricoVendas() {
        List<HistoricoVenda> historico = estoque.getHistoricoVendas();
        if (historico.isEmpty()) {
        	System.out.println("--------------------------------------");
            System.out.println("Nenhuma venda registrada até o momento.");
            System.out.println("--------------------------------------");
            return;
        }

        System.out.println("======== Histórico de Vendas ========");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        for (HistoricoVenda venda : historico) {
            System.out.println("\n-----------------------------------");
            System.out.println("Vendedor: " + venda.getVendedor().getUsuario());
            System.out.println("Data: " + sdf.format(venda.getDataVenda()));
            System.out.println("Total da Venda: R$ " + String.format("%.2f", venda.getTotalVenda()));
            System.out.println("Itens Vendidos:");

            for (ItemVenda item : venda.getItensVendidos()) {
                System.out.printf("- %s (Quantidade: %d, Preço Unitário: R$ %.2f)%n",
                        item.getProduto().getNome(),
                        item.getQuantidade(),
                        item.getProduto().getPreco());
            }
            System.out.println("-----------------------------------");
        }
    }
}