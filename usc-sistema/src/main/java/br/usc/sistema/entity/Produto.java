package br.usc.sistema.entity;

public class Produto implements Cloneable {
	private int id;
	private String nome;
	private String descricao;
	private double preco;
	private int quantidade;

	public Produto(String nome, String descricao, double preco, int quantidade) {
		super();
		this.id = 0;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isValid() {
		if (this.descricao != null && !this.descricao.isEmpty() && this.nome != null && !this.nome.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Produto clone() throws CloneNotSupportedException {
		return (Produto) super.clone();
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", quantidade=" + quantidade + "]";
	}
}
