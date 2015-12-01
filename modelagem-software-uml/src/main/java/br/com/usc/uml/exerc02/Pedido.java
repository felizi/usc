package br.com.usc.uml.exerc02;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private List<Produto> produtoList;

	public Pedido() {
		this.produtoList = new ArrayList<Produto>();
	}

	public boolean adicionar(Produto produto) {
		return this.produtoList.add(produto);
	}

	public double calcularValor() {
		double total = 0;
		for (Produto produto : produtoList) {
			total += produto.getPreco();
		}
		return total;
	}
}
