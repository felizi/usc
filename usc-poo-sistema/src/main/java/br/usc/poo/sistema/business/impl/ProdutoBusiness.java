package br.usc.poo.sistema.business.impl;

import java.util.ArrayList;
import java.util.List;

import br.usc.poo.sistema.business.ProdutoBusinessInterface;
import br.usc.poo.sistema.entity.Produto;
import br.usc.poo.sistema.exception.ProdutoNaoExisteException;
import br.usc.poo.sistema.repository.ProdutoRepository;

/**
 * Classe ProdutoBusiness.
 */
public class ProdutoBusiness implements ProdutoBusinessInterface {
	private ProdutoRepository produtoRepository;

	/**
	 * Construtor
	 *
	 * @param produtoRepository the produto repository
	 */
	private ProdutoBusiness(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}

	/**
	 * Método construtor
	 *
	 * @return the produto business
	 */
	public static ProdutoBusiness of() {
		return new ProdutoBusiness(ProdutoRepository.of());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.usc.poo.sistema.business.ProdutoBusinessInterface#inserirProduto(java.
	 * lang.String, double, int)
	 */
	@Override
	public Produto inserirProduto(String nome, double valor, int quantidade) {
		return this.produtoRepository.create(nome, valor, quantidade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.usc.poo.sistema.business.ProdutoBusinessInterface#obterProdutos()
	 */
	@Override
	public List<Produto> obterProdutos() {
		return this.produtoRepository.readAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.usc.poo.sistema.business.ProdutoBusinessInterface#obterProdutos(java.
	 * util.List)
	 */
	@Override
	public List<Produto> obterProdutos(List<Integer> codigoProdutos) throws ProdutoNaoExisteException {
		List<Produto> produtosFiltrados = new ArrayList<>();
		for (Integer codigoProduto : codigoProdutos) {
			Produto produto = this.produtoRepository.read(codigoProduto);
			if (produto != null) {
				produtosFiltrados.add(produto);
			} else {
				throw new ProdutoNaoExisteException();
			}
		}
		return produtosFiltrados;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.usc.poo.sistema.business.ProdutoBusinessInterface#obterProduto(int)
	 */
	@Override
	public Produto obterProduto(int codigoProduto) throws ProdutoNaoExisteException {
		return this.produtoRepository.read(codigoProduto);
	}
}
