package storeManager;

public class Calca extends Produto implements Desconto {
    private int tamanho;
    private String modelo;

    public Calca(int codigo, String nome, double preco, int quantidadeEstoque, int tamanho, String modelo) {
        super(codigo, nome, preco, quantidadeEstoque);
        this.tamanho = tamanho;
        this.modelo = modelo;
    }

    @Override
    public double calcularDesconto() {
        return getPreco() * 0.15; // 15% de desconto
    }
}