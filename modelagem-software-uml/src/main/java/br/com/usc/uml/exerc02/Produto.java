package br.com.usc.uml.exerc02;

import java.util.Random;

public class Produto {
	private int id;
	private String descricao;
	private double preco;
	private int quantidade;

	public Produto(String descricao, double preco, int quantidade) {
		super();
		this.id = new Random().nextInt(0);
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public int getId() {
		return this.id;
	}

	public double getPreco() {
		return this.preco;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
