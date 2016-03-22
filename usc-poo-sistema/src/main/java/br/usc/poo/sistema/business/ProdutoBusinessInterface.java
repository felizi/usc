package br.usc.poo.sistema.business;

import java.util.List;

import br.usc.poo.sistema.entity.Produto;
import br.usc.poo.sistema.exception.ProdutoNaoExisteException;

/**
 * Interface ProdutoBusiness.
 */
public interface ProdutoBusinessInterface {
	/**
	 * Inserir produto.
	 *
	 * @param nome do produto
	 * @param valor unitário
	 * @param quantidade de produtos
	 * @return produto
	 */
	public Produto inserirProduto(String nome, double valor, int quantidade);

	/**
	 * Obter produtos.
	 *
	 * @return uma lista de produtos
	 */
	public List<Produto> obterProdutos();

	/**
	 * Obter produtos.
	 *
	 * @param codigoProdutos codigo dos produtos
	 * @return uma lista de produtos pelo código
	 * @throws ProdutoNaoExisteException se o produto não existe
	 */
	public List<Produto> obterProdutos(List<Integer> codigoProdutos) throws ProdutoNaoExisteException;

	/**
	 * Obter produto.
	 *
	 * @param codigoProduto codigo produto a ser buscado
	 * @return um produto
	 * @throws ProdutoNaoExisteException se o produto não existe
	 */
	public Produto obterProduto(int codigoProduto) throws ProdutoNaoExisteException;
}
