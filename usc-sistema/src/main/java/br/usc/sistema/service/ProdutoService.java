package br.usc.sistema.service;

import java.util.List;

import br.usc.sistema.entity.Produto;
import br.usc.sistema.exception.InvalidParameterException;
import br.usc.sistema.exception.InvalidProductException;
import br.usc.sistema.exception.ProductDoesNotExistException;

public class ProdutoService {

	public Produto adicionar(Produto produto) throws InvalidProductException {
		return RepositoryFactory.getProdutoRepository().adicionar(produto);
	}

	public List<Produto> pesquisarProdutos() {
		return RepositoryFactory.getProdutoRepository().pesquisarProdutos();
	}

	public Produto pesquisarProdutos(int id) throws InvalidParameterException {
		return RepositoryFactory.getProdutoRepository().pesquisarProdutos(id);
	}

	public List<Produto> pesquisarProdutos(String nome) throws InvalidParameterException {
		return RepositoryFactory.getProdutoRepository().pesquisarProdutos(nome);
	}

	public Produto alterarProduto(Produto produto) throws ProductDoesNotExistException, InvalidProductException, InvalidParameterException {
		return RepositoryFactory.getProdutoRepository().alterarProduto(produto);
	}

	public boolean excluir(int id) {
		return RepositoryFactory.getProdutoRepository().excluir(id);
	}
}
