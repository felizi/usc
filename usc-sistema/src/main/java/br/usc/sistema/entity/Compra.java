package br.usc.sistema.entity;

import java.util.List;

import br.usc.sistema.service.PagamentoService;

public class Compra {
	private List<Pedido> pedidos;
	private List<PagamentoService> pagamentos;
	private double valorTotal;

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidoList(List<Pedido> pedidoList) {
		this.pedidos = pedidoList;
	}

	public List<PagamentoService> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<PagamentoService> pagamentoList) {
		this.pagamentos = pagamentoList;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
