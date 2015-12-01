package br.com.usc.uml.exerc04;

import java.util.List;

import br.com.usc.uml.exerc02.Pedido;
import br.com.usc.uml.exerc03.Pagamento;

public class Compra {
	private List<Pedido> pedidos;
	private List<Pagamento> pagamentos;
	private double valorTotal;

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidoList(List<Pedido> pedidoList) {
		this.pedidos = pedidoList;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentoList) {
		this.pagamentos = pagamentoList;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
