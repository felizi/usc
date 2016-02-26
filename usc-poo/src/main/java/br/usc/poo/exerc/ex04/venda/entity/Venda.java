package br.usc.poo.exerc.ex04.venda.entity;

import java.util.Date;
import java.util.List;

public class Venda {
	private int codigo;
	private Vendedor vendedor;
	private Date data;
	private List<Produto> produtos;

	public Venda(int codigo, Vendedor vendedor, Date date, List<Produto> produtos) {
		super();
		this.codigo = codigo;
		this.vendedor = vendedor;
		this.data = date;
		this.produtos = produtos;
	}

	public double somarTotalVendas() {
		double totalVendas = 0;
		for (Produto produto : produtos) {
			totalVendas += produto.getValor();
		}
		return totalVendas;
	}

	public int getCodigo() {
		return codigo;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public Date getData() {
		return data;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
}
