package storeManager;

public class Login {
    public static Funcionario autenticar(String usuario, String senha, Funcionario[] funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(usuario) && funcionario.getSenha().equals(senha)) {
                return funcionario;
            }
        }
        return null; // Autenticação falhou
    }
}