package br.usc.poo.sistema.service.impl;

import java.util.List;

import javax.jws.WebService;

import br.usc.poo.sistema.business.ProdutoBusinessInterface;
import br.usc.poo.sistema.business.impl.ProdutoBusiness;
import br.usc.poo.sistema.entity.Produto;
import br.usc.poo.sistema.exception.ProdutoNaoExisteException;
import br.usc.poo.sistema.service.ProdutoServiceInterface;

@WebService(endpointInterface = "br.usc.poo.sistema.service.ProdutoServiceInterface")
public class ProdutoService implements ProdutoServiceInterface {
	private ProdutoBusinessInterface produtoBusiness = ProdutoBusiness.of();

	@Override
	public Produto inserirProduto(String nome, double valor, int quantidade) {
		return this.produtoBusiness.inserirProduto(nome, valor, quantidade);
	}

	@Override
	public List<Produto> obterTodosProdutos() {
		return this.produtoBusiness.obterProdutos();
	}

	@Override
	public Produto obterProduto(Integer codigoProduto) throws ProdutoNaoExisteException {
		return this.produtoBusiness.obterProduto(codigoProduto);
	}

}
