package storeManager;

public class Vestido extends Produto implements Desconto {
    private String comprimento;
    private String estampa;

    public Vestido(int codigo, String nome, double preco, int quantidadeEstoque, String comprimento, String estampa) {
        super(codigo, nome, preco, quantidadeEstoque);
        this.comprimento = comprimento;
        this.estampa = estampa;
    }

    @Override
    public double calcularDesconto() {
        return getPreco() * 0.10; // 10% de desconto
    }
}