package br.usc.poo.sistema.service;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.usc.poo.sistema.entity.Venda;
import br.usc.poo.sistema.exception.ProdutoNaoExisteException;
import br.usc.poo.sistema.exception.VendedorNaoExisteException;

/**
 * Interface de Serviço.
 */
@WebService
public interface VendaServiceInterface {

	/**
	 * Obter total de vendas realizadas no mês.
	 *
	 * @param mes a ser filtrado
	 * @return um double
	 */
	@WebMethod
	public double obterTotalVendasRealizadasMes(int mes);

	/**
	 * Obter total comissão sobre vendas realizadas por um determinado vendedor
	 * no mês.
	 *
	 * @param codigoVendedor codigo vendedor
	 * @param mes a ser filtrado
	 * @return total de comissão sobre vendas feitas por um vendedor em um
	 *         determinado mês
	 */
	@WebMethod
	public double obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedorMes(@WebParam(name = "codigoVendedor") int codigoVendedor, @WebParam(name = "numeroMes") int mes);

	/**
	 * Obter total comissão sobre vendas realizadas por um determinado vendedor.
	 *
	 * @param codigoVendedor codigo vendedor
	 * @return total de comissão sobre vendas feitas por um vendedor
	 */
	@WebMethod
	public double obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedor(@WebParam(name = "codigoVendedor") int codigoVendedor);

	/**
	 * Obter total vendas realizadas por um determinado vendedor.
	 *
	 * @param codigoVendedor codigo vendedor
	 * @return quantidade/total de vendas realizadas por determinado vendedor
	 */
	@WebMethod
	public double obterTotalVendasRealizadasPorDeterminadoVendedor(@WebParam(name = "codigoVendedor") int codigoVendedor);

	/**
	 * Obter total vendas realizadas por um determinado vendedor no mês.
	 *
	 * @param codigoVendedor codigo vendedor
	 * @param mes a ser filtrado
	 * @return total de vendas realizadas por um vendedor no mês
	 */
	@WebMethod
	public double obterTotalVendasRealizadasPorDeterminadoVendedorMes(@WebParam(name = "codigoVendedor") int codigoVendedor, @WebParam(name = "numeroMes") int mes);

	/**
	 * Realizar uma nova venda.
	 *
	 * @param codigoVendedor da venda
	 * @param date da venda
	 * @param produtos vendidos
	 * @return venda
	 * @throws ProdutoNaoExisteException the produto nao existe exception
	 * @throws VendedorNaoExisteException the vendedor nao existe exception
	 */
	@WebMethod
	public Venda realizarVenda(@WebParam(name = "codigoVendedor") int codigoVendedor, @WebParam(name = "data") Date date, @WebParam(name = "produtos") String produtos) throws ProdutoNaoExisteException, VendedorNaoExisteException;
}