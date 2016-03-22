package br.usc.poo.sistema.service.impl;

import java.util.List;

import javax.jws.WebService;

import br.usc.poo.sistema.business.VendedorBusinessInterface;
import br.usc.poo.sistema.business.impl.VendedorBusiness;
import br.usc.poo.sistema.entity.Vendedor;
import br.usc.poo.sistema.service.VendedorServiceInterface;

@WebService(endpointInterface = "br.usc.poo.sistema.service.VendedorServiceInterface")
public class VendedorService implements VendedorServiceInterface {
	private VendedorBusinessInterface vendedorBusiness = VendedorBusiness.of();

	@Override
	public Vendedor inserirVendedor(String nome, double percentualComissao) {
		return this.vendedorBusiness.inserirVendedor(nome, percentualComissao);
	}

	@Override
	public List<Vendedor> obterTodosVendedores() {
		return this.vendedorBusiness.obterTodosVendedores();
	}

	@Override
	public Vendedor obterVendedor(int codigoVendedor) {
		return this.vendedorBusiness.obterVendedor(codigoVendedor);
	}
}
