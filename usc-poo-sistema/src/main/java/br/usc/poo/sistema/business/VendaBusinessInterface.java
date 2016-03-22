package br.usc.poo.sistema.business;

import java.util.Date;
import java.util.List;

import br.usc.poo.sistema.entity.OperadorSentencialEnum;
import br.usc.poo.sistema.entity.Produto;
import br.usc.poo.sistema.entity.Venda;
import br.usc.poo.sistema.entity.Vendedor;

/**
 * Interface VendaBusinessInterface.
 */
public interface VendaBusinessInterface {

	/**
	 * Realizar venda.
	 *
	 * @param vendedor que realizou a venda
	 * @param date da venda
	 * @param produtos vendidos
	 * @return venda
	 */
	public Venda realizarVenda(Vendedor vendedor, Date date, List<Produto> produtos);

	/**
	 * Obter vendas realizadas mês.
	 *
	 * @param mes a ser filtrado
	 * @return vendas feitas no mês
	 */
	public List<Venda> obterVendasRealizadasMes(int mes);

	/**
	 * Obter quantidade vendas por valor produto.
	 *
	 * @param operadorSentencial operador para o cálculo
	 * @param valor a ser filtrado
	 * @return quantidade de vendas por valor de produto X
	 */
	public int obterQuantidadeVendasPorValorProduto(OperadorSentencialEnum operadorSentencial, double valor);

	/**
	 * Obter total vendas realizadas mês.
	 *
	 * @param mes a ser filtrado
	 * @return total de vendas realizadas no mês
	 */
	public double obterTotalVendasRealizadasMes(int mes);

	/**
	 * Obter vendas realizadas vendedor.
	 *
	 * @param codigoVendedor codigo vendedor
	 * @param vendas a serem filtradas
	 * @return relação de vendas por determinado vendedor
	 */
	public List<Venda> obterVendasRealizadasVendedor(int codigoVendedor, List<Venda> vendas);

	/**
	 * Obter total comissão sobre vendas realizadas por um determinado vendedor
	 * no mês.
	 *
	 * @param codigoVendedor codigo vendedor
	 * @param mes a ser filtrado
	 * @return total de comissão sobre vendas feitas por um vendedor em um
	 *         determinado mês
	 */
	public double obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedorMes(int codigoVendedor, int mes);

	/**
	 * Obter total comissão sobre vendas realizadas por um determinado vendedor.
	 *
	 * @param codigoVendedor codigo vendedor
	 * @return total de comissão sobre vendas feitas por um vendedor
	 */
	public double obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedor(int codigoVendedor);

	/**
	 * Obter total vendas realizadas por um determinado vendedor.
	 *
	 * @param codigoVendedor codigo vendedor
	 * @return quantidade/total de vendas realizadas por determinado vendedor
	 */
	public double obterTotalVendasRealizadasPorDeterminadoVendedor(int codigoVendedor);

	/**
	 * Obter total vendas realizadas por um determinado vendedor no mês.
	 *
	 * @param codigoVendedor codigo vendedor
	 * @param mes a ser filtrado
	 * @return total de vendas realizadas por um vendedor no mês
	 */
	public double obterTotalVendasRealizadasPorDeterminadoVendedorMes(int codigoVendedor, int mes);

}
