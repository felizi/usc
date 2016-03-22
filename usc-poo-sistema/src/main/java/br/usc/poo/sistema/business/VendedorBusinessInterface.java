package br.usc.poo.sistema.business;

import java.util.List;

import br.usc.poo.sistema.entity.Vendedor;

/**
 * Interface VendedorBusinessInterface.
 */
public interface VendedorBusinessInterface {

	/**
	 * Inserir um vendedor.
	 *
	 * @param nome do vendedor a ser inserido
	 * @param percentualComissao percentual de comissão
	 * @return vendendor inserido
	 */
	public Vendedor inserirVendedor(String nome, double percentualComissao);

	/**
	 * Obter todos vendedores.
	 *
	 * @return lista de vendedores
	 */
	public List<Vendedor> obterTodosVendedores();

	/**
	 * Obter vendedor.
	 *
	 * @param codigoVendedor a ser buscado
	 * @return vendedor pelo código
	 */
	public Vendedor obterVendedor(int codigoVendedor);
}
