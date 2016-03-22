package br.usc.poo.sistema.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import br.usc.poo.sistema.business.ProdutoBusinessInterface;
import br.usc.poo.sistema.business.VendaBusinessInterface;
import br.usc.poo.sistema.business.VendedorBusinessInterface;
import br.usc.poo.sistema.business.impl.ProdutoBusiness;
import br.usc.poo.sistema.business.impl.VendaBusiness;
import br.usc.poo.sistema.business.impl.VendedorBusiness;
import br.usc.poo.sistema.entity.Produto;
import br.usc.poo.sistema.entity.Venda;
import br.usc.poo.sistema.entity.Vendedor;
import br.usc.poo.sistema.exception.ProdutoNaoExisteException;
import br.usc.poo.sistema.exception.VendedorNaoExisteException;
import br.usc.poo.sistema.service.VendaServiceInterface;

@WebService(endpointInterface = "br.usc.poo.sistema.service.VendaServiceInterface")
public class VendaService implements VendaServiceInterface {
	private VendaBusinessInterface vendaBusiness = VendaBusiness.of();
	private VendedorBusinessInterface vendedorBusiness = VendedorBusiness.of();
	private ProdutoBusinessInterface produtoBusiness = ProdutoBusiness.of();

	@Override
	public double obterTotalVendasRealizadasMes(int mes) {
		return this.vendaBusiness.obterTotalVendasRealizadasMes(mes);
	}

	@Override
	public double obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedorMes(int codigoVendedor, int mes) {
		return this.vendaBusiness.obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedorMes(codigoVendedor, mes);
	}

	@Override
	public double obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedor(int codigoVendedor) {
		return this.vendaBusiness.obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedor(codigoVendedor);
	}

	@Override
	public double obterTotalVendasRealizadasPorDeterminadoVendedor(int codigoVendedor) {
		return this.vendaBusiness.obterTotalVendasRealizadasPorDeterminadoVendedor(codigoVendedor);
	}

	@Override
	public double obterTotalVendasRealizadasPorDeterminadoVendedorMes(int codigoVendedor, int mes) {
		return this.vendaBusiness.obterTotalVendasRealizadasPorDeterminadoVendedorMes(codigoVendedor, mes);
	}

	@Override
	public Venda realizarVenda(int codigoVendedor, Date date, String codigosProdutos) throws ProdutoNaoExisteException, VendedorNaoExisteException {
		List<Integer> codigosProdutosList = new ArrayList<>();

		if (codigosProdutos != null && !codigosProdutos.trim().isEmpty()) {
			String[] codigosProdutosArray = codigosProdutos.split(";");

			if (codigosProdutosArray != null && codigosProdutosArray.length > 0) {
				for (String codigoProduto : codigosProdutosArray) {
					codigosProdutosList.add(Integer.valueOf(codigoProduto));
				}
			}
		}

		Vendedor vendedor = this.vendedorBusiness.obterVendedor(codigoVendedor);
		if (vendedor == null) {
			throw new VendedorNaoExisteException();
		}

		List<Produto> produtosList = this.produtoBusiness.obterProdutos(codigosProdutosList);

		return this.vendaBusiness.realizarVenda(vendedor, date, produtosList);
	}

}
