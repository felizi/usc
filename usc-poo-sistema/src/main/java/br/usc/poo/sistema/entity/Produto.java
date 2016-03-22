package br.usc.poo.sistema.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe Produto.
 */
@XmlRootElement(name = "produto")
public class Produto {
	/** Código do produto. */
	private int codigo;

	/** Nome. */
	private String nome;

	/** Valor unitário. */
	private double valor;

	/** Quantidade. */
	private int quantidade;

	/**
	 * Instantiates um novo produto.
	 */
	public Produto() {
		super();
	}

	/**
	 * Instancia um novo produto.
	 *
	 * @param codigo do produto novo
	 * @param nome do produto novo
	 * @param valor unitário do produto novo
	 * @param quantidade de produtos
	 */
	public Produto(int codigo, String nome, double valor, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	/**
	 * Retorna o código
	 *
	 * @return codigo
	 */
	@XmlElement(name = "codigo")
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Retorna o nome.
	 *
	 * @return nome
	 */
	@XmlElement(name = "nome")
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o valor.
	 *
	 * @return valor
	 */
	@XmlElement(name = "valor")
	public double getValor() {
		return valor;
	}

	/**
	 * Retorna a quantidade.
	 *
	 * @return quantidade
	 */
	@XmlElement(name = "quantidade")
	public int getQuantidade() {
		return quantidade;
	}

}
