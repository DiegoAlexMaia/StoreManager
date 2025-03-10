package storeManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();
        GerenciamentoEstoque gerenciamentoEstoque = new GerenciamentoEstoque(estoque);
        GerenciamentoVenda gerenciamentoVenda = new GerenciamentoVenda(estoque, null); // Inicialmente sem vendedor

        // Inicialização dos produtos
        inicializarProdutos(estoque);

        // Cadastro de funcionários
        Funcionario[] funcionarios = {
            new Gerente("João da Silva", "senha", "gerente1"),
            new Gerente("Mariana Souza", "senha", "gerente2"),
            new Vendedor("Fernanda Costa", "senha", "vendedor1"),
            new Vendedor("Tatiane Oliveira", "senha", "vendedor2"),
            new Vendedor("Antônio Nunes", "senha", "vendedor3")
        };

        System.out.println("======================================");
        System.out.println("Bem-vindo ao Sistema de Caixa da Loja!");
        System.out.println("======================================");

        while (true) {
            try {
                System.out.print("\nUsuário: ");
                String usuario = scanner.nextLine();
                System.out.print("Senha: ");
                String senha = scanner.nextLine();

                Funcionario funcionarioLogado = Login.autenticar(usuario, senha, funcionarios);

                if (funcionarioLogado == null) {
                    System.out.println("\n--------------------------------------------");
                    System.out.println("Usuário ou senha incorretos. Tente novamente.");
                    System.out.println("--------------------------------------------");
                } else if (funcionarioLogado instanceof Gerente) {
                    MenuGerente menuGerente = new MenuGerente(gerenciamentoEstoque, estoque);
                    menuGerente.exibirMenu(scanner);
                } else if (funcionarioLogado instanceof Vendedor) {
                    Vendedor vendedorLogado = (Vendedor) funcionarioLogado; // Cast para Vendedor
                    gerenciamentoVenda = new GerenciamentoVenda(estoque, vendedorLogado); // Atualiza o vendedor logado
                    MenuVendedor menuVendedor = new MenuVendedor(gerenciamentoVenda, vendedorLogado,gerenciamentoEstoque);
                    menuVendedor.exibirMenu(scanner);
                }
            } catch (InputMismatchException e) {
            	System.out.println("\n---------------------------------------");
                System.out.println("Erro: Entrada inválida. Tente novamente.");
                System.out.println("---------------------------------------");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }
    }

    // Método para inicializar produtos no estoque
    private static void inicializarProdutos(Estoque estoque) {
        estoque.adicionarProduto(new Camiseta(1, "Camiseta Branca", 29.90, 50, "M", "Branca"));
        estoque.adicionarProduto(new Calca(2, "Calça Jeans", 89.90, 30, 42, "Skinny"));
        estoque.adicionarProduto(new Vestido(3, "Vestido Floral", 120.00, 20, "Longo", "Floral"));
        estoque.adicionarProduto(new Casaco(4, "Casaco de Inverno", 150.00, 15, "Lã", "Zíper"));
    }
}