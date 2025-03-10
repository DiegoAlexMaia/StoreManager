package storeManager;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<ItemVenda> itens = new ArrayList<>();

    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            double precoComDesconto = item.getProduto().getPreco();
            if (item.getProduto() instanceof Desconto) {
                Desconto produtoComDesconto = (Desconto) item.getProduto();
                precoComDesconto -= produtoComDesconto.calcularDesconto();
            }
            total += precoComDesconto * item.getQuantidade();
        }
        return total;
    }

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}
}