package br.usc.sistema.service;

import br.usc.sistema.repository.impl.ProdutoRepository;

public class RepositoryFactory {
	private static ProdutoRepository produtoRepository;

	public static ProdutoRepository getProdutoRepository() {
		if (produtoRepository == null) {
			produtoRepository = new ProdutoRepository();
		}
		return produtoRepository;
	}
}
