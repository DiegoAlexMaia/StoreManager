package storeManager;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos = new ArrayList<>();
    private List<HistoricoVenda> historicoVendas = new ArrayList<>(); // Histórico de vendas centralizado

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto buscarProdutoPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null; // Produto não encontrado
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    // Método para adicionar uma venda ao histórico
    public void adicionarVendaAoHistorico(HistoricoVenda venda) {
        historicoVendas.add(venda);
    }

    // Método para obter o histórico de vendas
    public List<HistoricoVenda> getHistoricoVendas() {
        return historicoVendas;
    }
}