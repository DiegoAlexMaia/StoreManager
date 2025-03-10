package storeManager;

public class Camiseta extends Produto implements Desconto {
    private String tamanho;
    private String cor;

    public Camiseta(int codigo, String nome, double preco, int quantidadeEstoque, String tamanho, String cor) {
        super(codigo, nome, preco, quantidadeEstoque);
        this.tamanho = tamanho;
        this.cor = cor;
    }

    @Override
    public double calcularDesconto() {
        return getPreco() * 0.20; // 20% de desconto
    }
}