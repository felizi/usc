package br.usc.sistema.repository;

import java.util.List;

import br.usc.sistema.entity.Produto;
import br.usc.sistema.exception.InvalidParameterException;
import br.usc.sistema.exception.InvalidProductException;
import br.usc.sistema.exception.ProductDoesNotExistException;

public interface ProdutoRepositoryInterface {

	public Produto adicionar(Produto produto) throws InvalidProductException;

	public List<Produto> pesquisarProdutos();

	public Produto pesquisarProdutos(int id) throws InvalidParameterException;

	public List<Produto> pesquisarProdutos(String nome) throws InvalidParameterException;

	public Produto alterarProduto(Produto produto) throws ProductDoesNotExistException, InvalidProductException, InvalidParameterException;

	public boolean excluir(int id);
}
