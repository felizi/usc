package br.usc.poo.sistema.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe Vendedor.
 */
@XmlRootElement(name = "vendedor")
public class Vendedor {
	private int codigo;
	private String nome;
	private Double percentualComissao;

	/**
	 * Instancia um novo vendedor.
	 */
	public Vendedor() {
		super();
	}

	/**
	 * Instantiates um novo vendedor.
	 *
	 * @param codigo do vendedor
	 * @param nome do vendedor
	 * @param percentualComissao percentual comissão
	 */
	public Vendedor(int codigo, String nome, Double percentualComissao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.percentualComissao = percentualComissao;
	}

	/**
	 * Código do vendedor
	 *
	 * @return codigo
	 */
	@XmlElement
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Nome do vendedor
	 *
	 * @return nome
	 */
	@XmlElement
	public String getNome() {
		return nome;
	}

	/**
	 * Percentual comissão.
	 *
	 * @return percentual comissao
	 */
	@XmlElement
	public Double getPercentualComissao() {
		return percentualComissao;
	}
}