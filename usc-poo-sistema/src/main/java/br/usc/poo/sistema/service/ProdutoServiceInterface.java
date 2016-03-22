package br.usc.poo.sistema.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.usc.poo.sistema.entity.Produto;
import br.usc.poo.sistema.exception.ProdutoNaoExisteException;

/**
 * Interface de Serviço.
 */
@WebService
public interface ProdutoServiceInterface {

	/**
	 * Inserir um novo produto.
	 *
	 * @param nome do produto
	 * @param valor unitário
	 * @param quantidade de produtos
	 * @return o produto
	 */
	@WebMethod
	public Produto inserirProduto(@WebParam(name = "nome") String nome, @WebParam(name = "valor") double valor, @WebParam(name = "quantidade") int quantidade);

	/**
	 * Obter todos produtos cadastrados.
	 *
	 * @return uma lista
	 */
	@WebMethod
	public List<Produto> obterTodosProdutos();

	/**
	 * Obter um produto específico.
	 *
	 * @param codigoProduto a ser buscado
	 * @return o produto
	 * @throws ProdutoNaoExisteException se o produto não existe
	 */
	@WebMethod
	public Produto obterProduto(@WebParam(name = "codigo") Integer codigoProduto) throws ProdutoNaoExisteException;
}
