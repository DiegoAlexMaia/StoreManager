package storeManager;

public class Casaco extends Produto {
    private String material;
    private String tipoDeFecho;

    public Casaco(int codigo, String nome, double preco, int quantidadeEstoque, String material, String tipoDeFecho) {
        super(codigo, nome, preco, quantidadeEstoque);
        this.material = material;
        this.tipoDeFecho = tipoDeFecho;
    }
}