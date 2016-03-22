package br.usc.poo.sistema.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.usc.poo.sistema.entity.Vendedor;

/**
 * Interface de Serviço.
 */
@WebService
public interface VendedorServiceInterface {

	/**
	 * Inserir um vendedor.
	 *
	 * @param nome do novo vendedor
	 * @param percentualComissao percentual de comissão
	 * @return vendendor inserido
	 */
	@WebMethod
	public Vendedor inserirVendedor(@WebParam(name = "nome") String nome, @WebParam(name = "percentualComissao") double percentualComissao);

	/**
	 * Obter todos vendedores.
	 *
	 * @return lista de vendedores
	 */
	@WebMethod
	public List<Vendedor> obterTodosVendedores();

	/**
	 * Obter vendedor.
	 *
	 * @param codigoVendedor a ser buscado
	 * @return vendedor pelo código
	 */
	@WebMethod
	public Vendedor obterVendedor(@WebParam(name = "codigo") int codigoVendedor);

}
