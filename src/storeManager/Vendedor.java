package storeManager;

public class Vendedor extends Funcionario {
    private double comissao;

    public Vendedor(String nome, String senha, String cpf) {
        super(nome, senha, cpf);
        this.comissao = 0.0;
    }

    public void adicionarComissao(double valor) {
        this.comissao += valor;
    }

    public double getComissao() {
        return comissao;
    }
}