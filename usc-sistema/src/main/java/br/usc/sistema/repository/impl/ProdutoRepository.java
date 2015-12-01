package br.usc.sistema.repository.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.usc.log.enums.LogLevelEnum;
import br.usc.log.services.LogFactory;
import br.usc.log.services.impl.LogServiceImpl;
import br.usc.sistema.entity.Produto;
import br.usc.sistema.exception.InvalidParameterException;
import br.usc.sistema.exception.InvalidProductException;
import br.usc.sistema.exception.ProductDoesNotExistException;
import br.usc.sistema.repository.ProdutoRepositoryInterface;

public class ProdutoRepository implements ProdutoRepositoryInterface {

	private static LogServiceImpl log = LogFactory.getInstance().getLogServiceImpl();

	private int index = 0;
	private Map<Integer, Produto> repository = null;

	public ProdutoRepository() {
		log.logger(LogLevelEnum.INFO, "Inicializando repositório de produtos..");
		this.index++;
		this.repository = new HashMap<Integer, Produto>();
	}

	private Integer getIndex() {
		return this.index++;
	}

	public Produto adicionar(Produto produto) throws InvalidProductException {
		log.logger(LogLevelEnum.INFO, "Adicionando produto: " + produto.getNome());

		validarAdicionarProduto(produto);

		Integer id = getIndex();

		log.logger(LogLevelEnum.INFO, "Identificador gerado para o produto: " + id);

		produto.setId(id);

		this.repository.put(id, produto);

		try {

			log.logger(LogLevelEnum.INFO, "Retornando o produto: " + produto.getNome());

			return this.repository.get(id).clone();

		} catch (CloneNotSupportedException e) {

			log.logger(LogLevelEnum.ERROR, "Falha ao clonar o produto!");

			e.printStackTrace();
		}
		return null;
	}

	public List<Produto> pesquisarProdutos() {
		return new ArrayList<Produto>(repository.values());
	}

	public Produto pesquisarProdutos(int id) throws InvalidParameterException {
		log.logger(LogLevelEnum.INFO, "Pesquisando produto pelo identificador: " + id);

		if (id > 0) {
			try {
				Produto produto = repository.get(id).clone();

				log.logger(LogLevelEnum.INFO, "Encontrei o produto: '" + produto.getNome() + "' que atende a pesquisa pelo id '" + id + "'");

				return produto;
			} catch (CloneNotSupportedException e) {

				log.logger(LogLevelEnum.ERROR, "Falha ao clonar o produto!");

				e.printStackTrace();
			}
		}

		log.logger(LogLevelEnum.ERROR, "Identificador do produto a ser pesquisado é inválido!");

		throw new InvalidParameterException("Product id is invalid");
	}

	public List<Produto> pesquisarProdutos(String nome) throws InvalidParameterException {
		log.logger(LogLevelEnum.INFO, "Pesquisando produto pelo nome: '" + nome + "'");

		if (nome != null && !nome.isEmpty()) {

			List<Produto> filteredList = new ArrayList<Produto>();

			Collection<Produto> values = repository.values();

			for (Produto produto : values) {

				if (produto.getNome().toUpperCase().contains(nome.toUpperCase())) {
					log.logger(LogLevelEnum.INFO, "Encontrei o produto : '" + produto.getNome() + "' que atende a pesquisa por '" + nome + "'");

					try {

						filteredList.add(produto.clone());

					} catch (CloneNotSupportedException e) {
						log.logger(LogLevelEnum.ERROR, "Falha ao clonar o produto: " + produto.getNome());

						e.printStackTrace();
					}
				}
			}

			if (filteredList == null || filteredList.isEmpty()) {
				log.logger(LogLevelEnum.WARNING, "Não encontrei nenhum produto que atende a pesquisa por '" + nome + "'");
			}
			return filteredList;
		}

		log.logger(LogLevelEnum.ERROR, "Nome do produto a ser pesquisado é inválido!");

		throw new InvalidParameterException("Product name is invalid");
	}

	public Produto alterarProduto(Produto produto) throws ProductDoesNotExistException, InvalidProductException, InvalidParameterException {

		if (this.repository.containsKey(produto.getId()) && validarAlterarProduto(produto)) {

			log.logger(LogLevelEnum.INFO, "Alterando o produto: " + produto.getNome());

			Produto produtoOriginal = this.pesquisarProdutos(produto.getId());
			
			log.logger(LogLevelEnum.INFO, "Produto antes da alteração: " + produtoOriginal);
			log.logger(LogLevelEnum.INFO, "Produto após a alteração: " + produto);
			
			try {
				
				return this.repository.put(produto.getId(), produto).clone();

			} catch (CloneNotSupportedException e) {

				log.logger(LogLevelEnum.ERROR, "Falha ao clonar o produto: " + produto.getNome());

				e.printStackTrace();
			}
		} else {

			log.logger(LogLevelEnum.ERROR, "Produto a ser alterado não existe: " + produto.getNome());

			throw new ProductDoesNotExistException("Product does not exist");

		}
		return null;
	}

	public boolean excluir(int id) {

		if (this.repository.containsKey(id)) {

			log.logger(LogLevelEnum.INFO, "Excluindo o identificador: " + id);

			this.repository.remove(id);

			return true;
		}

		log.logger(LogLevelEnum.WARNING, "Falha ao excluir o identificador: " + id);

		return false;
	}

	private boolean validarAlterarProduto(Produto produto) throws InvalidProductException {
		validarProduto(produto);

		return true;
	}

	private boolean validarProduto(Produto produto) throws InvalidProductException {

		if (produto == null) {

			log.logger(LogLevelEnum.ERROR, "Falha na validação, o produto está nulo!");

			throw new InvalidProductException("Product is null");

		}

		if (!produto.isValid()) {

			log.logger(LogLevelEnum.ERROR, "Falha na validação, o produto está inválido!");

			throw new InvalidProductException("Product is invalid");

		}

		if (produto.getId() < 0) {

			log.logger(LogLevelEnum.ERROR, "Falha na validação, o id do produto é inválido (menor que zero)!");

			throw new InvalidProductException("Product id is invalid");

		}

		return true;
	}

	private boolean validarAdicionarProduto(Produto produto) throws InvalidProductException {
		validarProduto(produto);

		if (produto.getId() != 0) {

			log.logger(LogLevelEnum.ERROR, "Falha na validação, o id do novo produto é diferente de zero!");

			throw new InvalidProductException("Product already has an identifier");

		}

		return true;
	}
}
