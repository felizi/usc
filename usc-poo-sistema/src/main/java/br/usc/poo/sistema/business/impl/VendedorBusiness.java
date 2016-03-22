package br.usc.poo.sistema.business.impl;

import java.util.List;

import br.usc.poo.sistema.business.VendedorBusinessInterface;
import br.usc.poo.sistema.entity.Vendedor;
import br.usc.poo.sistema.repository.VendedorRepository;

/**
 * Classe VendedorBusiness.
 */
public class VendedorBusiness implements VendedorBusinessInterface {
	private VendedorRepository vendedorRepository;

	/**
	 * Construtor
	 *
	 * @param vendedorRepository the vendedor repository
	 */
	private VendedorBusiness(VendedorRepository vendedorRepository) {
		super();
		this.vendedorRepository = vendedorRepository;
	}

	/**
	 * Método contrutor
	 *
	 * @return the vendedor business
	 */
	public static VendedorBusiness of() {
		return new VendedorBusiness(VendedorRepository.of());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.usc.poo.sistema.business.VendedorBusinessInterface#
	 * obterTodosVendedores()
	 */
	@Override
	public List<Vendedor> obterTodosVendedores() {
		return this.vendedorRepository.readAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.usc.poo.sistema.business.VendedorBusinessInterface#inserirVendedor(
	 * java.lang.String, double)
	 */
	@Override
	public Vendedor inserirVendedor(String nome, double percentualComissao) {
		return this.vendedorRepository.create(nome, percentualComissao);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.usc.poo.sistema.business.VendedorBusinessInterface#obterVendedor(int)
	 */
	@Override
	public Vendedor obterVendedor(int codigoVendedor) {
		return this.vendedorRepository.read(codigoVendedor);
	}

}
