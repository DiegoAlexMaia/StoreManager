package storeManager;

import java.util.Date;
import java.util.List;

public class HistoricoVenda {
    private Vendedor vendedor;
    private Date dataVenda;
    private List<ItemVenda> itensVendidos;
    private double totalVenda;

    public HistoricoVenda(Vendedor vendedor, List<ItemVenda> itensVendidos, double totalVenda) {
        this.vendedor = vendedor;
        this.dataVenda = new Date(); // Data atual
        this.itensVendidos = itensVendidos;
        this.totalVenda = totalVenda;
    }

    // Getters
    public Vendedor getVendedor() {
        return vendedor;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public List<ItemVenda> getItensVendidos() {
        return itensVendidos;
    }

    public double getTotalVenda() {
        return totalVenda;
    }
}