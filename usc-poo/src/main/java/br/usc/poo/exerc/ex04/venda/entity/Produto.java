package br.usc.poo.exerc.ex04.venda.entity;

public class Produto {
	private int codigo;
	private String nome;
	private double valor;
	private int quantidade;

	public Produto(int codigo, String nome, double valor, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

}
