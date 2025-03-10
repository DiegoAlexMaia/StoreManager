package storeManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciamentoVenda {
    private Estoque estoque;
    private Vendedor vendedorLogado;

    public GerenciamentoVenda(Estoque estoque, Vendedor vendedorLogado) {
        this.estoque = estoque;
        this.vendedorLogado = vendedorLogado;
    }

    public void iniciarVenda(Scanner scanner) {
        Venda venda = new Venda();
        double descontoTotal = 0;

        while (true) {
            try {
                System.out.print("Digite o código do produto (ou 0 para finalizar): ");
                
                if (!scanner.hasNextInt()) { // Verifica se a entrada é um número válido
                	System.out.println("\n-----------------------------------------");
                    System.out.println("Entrada inválida! Digite um número válido.");
                    System.out.println("-----------------------------------------\n");
                    scanner.nextLine(); // Limpa a entrada incorreta
                    continue;
                }
                
                int codigo = scanner.nextInt();
                if (codigo == 0) break;

                Produto produto = estoque.buscarProdutoPorCodigo(codigo);
                if (produto == null) {
                    System.out.println("\n------------------------------");
                    System.out.println("Produto não encontrado!");
                    System.out.println("------------------------------\n");
                    continue;
                }

                System.out.print("Digite a quantidade: ");

                if (!scanner.hasNextInt()) { // Verifica se a entrada é um número válido
                    System.out.println("\nEntrada inválida! Digite um número válido.");
                    scanner.nextLine(); // Limpa a entrada incorreta
                    continue;
                }

                int quantidade = scanner.nextInt();

                if (quantidade > produto.getQuantidadeEstoque() || quantidade < 1) {
                    System.out.println("\n------------------------------");
                    System.out.println("Quantidade indisponível em estoque!");
                    System.out.println("------------------------------\n");
                    continue;
                }

                // Calcula o desconto do produto (se aplicável)
                if (produto instanceof Desconto) {
                    Desconto produtoComDesconto = (Desconto) produto;
                    descontoTotal += produtoComDesconto.calcularDesconto() * quantidade;
                }

                venda.adicionarItem(new ItemVenda(produto, quantidade));
                produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
                System.out.println("\n------------------------------");
                System.out.println("Produto adicionado à venda!");
                System.out.println("------------------------------\n");

            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida! Certifique-se de inserir números nos campos corretos.");
                scanner.nextLine(); // Limpa a entrada incorreta
            }
        }

        if (venda.getItens().isEmpty()) {
            System.out.println("\n--------------------------------------");
            System.out.println("Adicione um item para completar a venda!");
            System.out.println("--------------------------------------");
        } else {
            double totalVenda = venda.calcularTotal();
            double comissao = totalVenda * 0.05; // Calcula a comissão

            // Atualiza a comissão do vendedor
            vendedorLogado.adicionarComissao(comissao);

            System.out.println("\n-------------------------------");
            System.out.println("Venda concluída com sucesso!");
            System.out.println("-------------------------------");

            System.out.printf("\nTotal da venda: R$ %.2f%n", totalVenda);
            System.out.printf("Desconto aplicado: R$ %.2f%n", descontoTotal);
            System.out.printf("Comissão adicionada: R$ %.2f%n", comissao);

            // Adiciona a venda ao histórico centralizado
            estoque.adicionarVendaAoHistorico(new HistoricoVenda(vendedorLogado, venda.getItens(), totalVenda));
        }
    }
}
