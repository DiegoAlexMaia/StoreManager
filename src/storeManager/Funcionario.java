package storeManager;

public class Funcionario {
    private String nome;
    private String senha;
	private String cpf;

    public Funcionario(String usuario, String senha, String cpf) {
    	this.cpf = cpf;
        this.nome = usuario;
        this.senha = senha;
    }

    // Getters
    public String getUsuario() { return nome; }
    public String getSenha() { return senha; }
    public String getCpf() { return cpf; }
}