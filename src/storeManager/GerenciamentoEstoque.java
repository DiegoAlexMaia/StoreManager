package storeManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciamentoEstoque {
    private Estoque estoque;

    public GerenciamentoEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public void adicionarProduto(Scanner scanner) {
        try {
            System.out.print("Digite o código do produto: ");
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            // Verificar se o produto com o mesmo código já existe
            Produto produtoExistente = estoque.buscarProdutoPorCodigo(codigo);
            if (produtoExistente != null) {
                System.out.println("\n----------------------------------------------");
                System.out.println("Erro: Já existe um produto com o código " + codigo + "!");
                System.out.println("----------------------------------------------");
                return; // Retorna sem adicionar o produto
            }

            System.out.print("Digite o nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o preço do produto: ");
            double preco = scanner.nextDouble();

            System.out.print("Digite a quantidade em estoque: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha restante

            // Perguntar o tipo de produto
            System.out.println("Escolha o tipo do produto: ");
            System.out.println("1 - Camiseta");
            System.out.println("2 - Calça");
            System.out.println("3 - Casaco");
            System.out.println("4 - Vestido");
            int tipoProduto = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha restante

            Produto produto = null;

            // Criar o produto baseado no tipo escolhido
            switch (tipoProduto) {
                case 1:
                    System.out.print("Digite o tamanho da camiseta: ");
                    String tamanhoCamiseta = scanner.nextLine();
                    System.out.print("Digite a cor da camiseta: ");
                    String corCamiseta = scanner.nextLine();
                    produto = new Camiseta(codigo, nome, preco, quantidade, tamanhoCamiseta, corCamiseta);
                    break;
                case 2:
                    System.out.print("Digite o tamanho da calça: ");
                    int tamanhoCalca = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha restante
                    System.out.print("Digite o modelo da calça: ");
                    String modeloCalca = scanner.nextLine();
                    produto = new Calca(codigo, nome, preco, quantidade, tamanhoCalca, modeloCalca);
                    break;
                case 3:
                    System.out.print("Digite o material do casaco: ");
                    String materialCasaco = scanner.nextLine();
                    System.out.print("Digite o tipo de fecho do casaco: ");
                    String tipoFechoCasaco = scanner.nextLine();
                    produto = new Casaco(codigo, nome, preco, quantidade, materialCasaco, tipoFechoCasaco);
                    break;
                case 4:
                    System.out.print("Digite o comprimento do vestido: ");
                    String comprimentoVestido = scanner.nextLine();
                    System.out.print("Digite a estampa do vestido: ");
                    String estampaVestido = scanner.nextLine();
                    produto = new Vestido(codigo, nome, preco, quantidade, comprimentoVestido, estampaVestido);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    return; // Retorna se a opção for inválida
            }

            // Adiciona o produto ao estoque
            if (produto != null) {
                estoque.adicionarProduto(produto);
                System.out.println("\n------------------------------");
                System.out.println("Produto adicionado com sucesso!");
                System.out.println("------------------------------");
            }

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Certifique-se de inserir números nos campos corretos.");
            scanner.nextLine(); // Limpar o buffer do scanner
        }
    }

    public void removerProduto(Scanner scanner) {
        try {
            System.out.print("Digite o código do produto a ser removido: ");
            int codigo = scanner.nextInt();
            System.out.println("");

            Produto produto = estoque.buscarProdutoPorCodigo(codigo);
            if (produto != null) {
                estoque.getProdutos().remove(produto);
                System.out.println("-------------------------------");
                System.out.println("Produto removido com sucesso!");
                System.out.println("-------------------------------");
            } else {
                System.out.println("-------------------------------");
                System.out.println("Produto não encontrado!");
                System.out.println("-------------------------------");
            }
        } catch (InputMismatchException e) {
            System.out.println("-------------------------------");
            System.out.println("Entrada inválida! O código do produto deve ser um número.");
            System.out.println("-------------------------------");
            scanner.nextLine(); // Limpar o buffer do scanner
        }
    }

    public void alterarProduto(Scanner scanner) {
        try {
            System.out.print("Digite o código do produto a ser alterado: ");
            int codigo = scanner.nextInt();

            Produto produto = estoque.buscarProdutoPorCodigo(codigo);
            if (produto != null) {
                System.out.print("Digite o novo preço do produto: ");
                double novoPreco = scanner.nextDouble();
                produto.setPreco(novoPreco);

                System.out.print("Digite a nova quantidade em estoque: ");
                int novaQuantidade = scanner.nextInt();
                produto.setQuantidadeEstoque(novaQuantidade);

                System.out.println("Produto alterado com sucesso!");
            } else {
                System.out.println("Produto não encontrado!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Certifique-se de inserir números nos campos corretos.");
            scanner.nextLine(); // Limpar o buffer do scanner
        }
    }

    public void listarProdutos() {
        System.out.printf("%-8s | %-20s | %-12s | %-10s%n", "Código", "Produto", "Preço", "Estoque");
        System.out.println("--------------------------------------------------------");
        for (Produto produto : estoque.getProdutos()) {
            String nomeAbreviado = abreviarNome(produto.getNome(), 20); // Abrevia o nome para 20 caracteres
            System.out.printf("%-8d | %-20s | %-12.2f | %-10d%n", produto.getCodigo(), nomeAbreviado, produto.getPreco(), produto.getQuantidadeEstoque());
        }
    }

    // Método para abreviar o nome do produto
    private String abreviarNome(String nome, int tamanhoMaximo) {
        if (nome.length() <= tamanhoMaximo) {
            return nome; // Retorna o nome original se for menor ou igual ao tamanho máximo
        } else {
            return nome.substring(0, tamanhoMaximo - 3) + "..."; // Abrevia e adiciona "..." no final
        }
    }
}