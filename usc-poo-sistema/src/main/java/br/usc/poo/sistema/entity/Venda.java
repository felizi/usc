package br.usc.poo.sistema.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe Venda.
 */
@XmlRootElement(name = "venda")
public class Venda {
	private int codigo;
	private Vendedor vendedor;
	private Date data;
	private List<Produto> produtos;

	/**
	 * Instancia um objeto Venda.
	 */
	public Venda() {
		super();
	}

	/**
	 * Instantiates a new venda.
	 *
	 * @param codigo da venda
	 * @param vendedor do vendedor
	 * @param date da venda
	 * @param produtos vendidos
	 */
	public Venda(int codigo, Vendedor vendedor, Date date, List<Produto> produtos) {
		super();
		this.codigo = codigo;
		this.vendedor = vendedor;
		this.data = date;
		this.produtos = produtos;
	}

	/**
	 * Somar total vendas.
	 *
	 * @return double
	 */
	public double somarTotalVendas() {
		double totalVendas = 0;
		for (Produto produto : produtos) {
			totalVendas += produto.getValor();
		}
		return totalVendas;
	}

	/**
	 * Obter valor total comissao do vendedor.
	 * 
	 * @return double
	 */
	public double obterValorComissaoVendedor() {
		return this.getProdutos().stream().map(p -> p.getValor()).reduce(0d, (totalValorComissaoVenda, valorVenda) -> totalValorComissaoVenda + valorVenda * this.getVendedor().getPercentualComissao());
	}

	/**
	 * Código da venda
	 *
	 * @return codigo
	 */
	@XmlElement(name = "codigo")
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Vendedor que realizou a venda.
	 *
	 * @return vendedor
	 */
	@XmlElement(name = "vendedor")
	public Vendedor getVendedor() {
		return vendedor;
	}

	/**
	 * Data da venda
	 *
	 * @return data
	 */
	@XmlElement(name = "data")
	public Date getData() {
		return data;
	}

	/**
	 * Produtos vendidos.
	 *
	 * @return produtos
	 */
	@XmlElementWrapper(name = "produtos")
	@XmlElement(name = "produto")
	public List<Produto> getProdutos() {
		return produtos;
	}
}
