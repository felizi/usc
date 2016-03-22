package br.usc.poo.sistema.repository;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import br.usc.poo.sistema.entity.Produto;
import br.usc.poo.sistema.repository.generator.IdGenerator;

/**
 * Classe ProdutoRepository: camada responsável pela persistência/infra do produto
 */
public class ProdutoRepository {
	private static ProdutoRepository produtoRepositorySingleton;
	private IdGenerator idGenerator;
	private ConcurrentHashMap<Integer, Produto> mapProdutos = new ConcurrentHashMap<>();

	/**
	 * Instancia um ProdutoRepository
	 *
	 * @param gerador de id
	 * @param map de produtos
	 */
	private ProdutoRepository(IdGenerator idGenerator, ConcurrentHashMap<Integer, Produto> mapProdutos) {
		super();
		this.idGenerator = idGenerator;
		this.mapProdutos = mapProdutos;
	}

	/**
	 * Método responsável por construir um ProdutoRepository
	 *
	 * @return a instância do ProdutoRepository
	 */
	public static ProdutoRepository of() {
		if (ProdutoRepository.produtoRepositorySingleton == null) {
			ProdutoRepository.produtoRepositorySingleton = new ProdutoRepository(IdGenerator.of(), new ConcurrentHashMap<>());
		}
		return ProdutoRepository.produtoRepositorySingleton;
	}

	/**
	 * Criar um novo produto
	 *
	 * @param nome do produto
	 * @param valor unitário
	 * @param quantidade de produtos
	 * @return produto criado
	 */
	public Produto create(String nome, Double valor, Integer quantidade) {
		int codigo = this.idGenerator.generate();
		Produto produto = new Produto(codigo, nome, valor, quantidade);
		this.mapProdutos.put(codigo, produto);
		return produto;
	}

	/**
	 * Buscar todos os produtos
	 *
	 * @return retorna uma lista com todos os produtos
	 */
	public List<Produto> readAll() {
		return Collections.unmodifiableList(this.mapProdutos.entrySet().stream().map(p -> p.getValue()).collect(Collectors.toList()));
	}

	/**
	 * Buscar um produto por código
	 *
	 * @param codigo do produto a ser buscado
	 * @return objeto do produto
	 */
	public Produto read(int codigo) {
		return this.mapProdutos.get(codigo);
	}

	/**
	 * Realiza uma busca por produtos que tenham exatamente o nome a ser buscado
	 *
	 * @param nome a ser buscado
	 * @return uma lista de produtos que atendem a busca
	 */
	public List<Produto> read(String nome) {
		Predicate<Produto> predicate = p -> p.getNome().toUpperCase().contains(nome.toUpperCase());
		return Collections.unmodifiableList(this.mapProdutos.values().stream().filter(predicate).collect(Collectors.toList()));
	}

	/**
	 * Realiza um update no Produto
	 *
	 * @param codigo do produto
	 * @param nome do produto
	 * @param valor unitário
	 * @param quantidade de produtos
	 * @return objeto Produto
	 */
	public Produto update(int codigo, String nome, Double valor, Integer quantidade) {
		Produto produto = new Produto(codigo, nome, valor, quantidade);
		this.mapProdutos.put(codigo, produto);
		return produto;
	}

	/**
	 * Excluí o produto pelo código
	 *
	 * @param codigo do produto a ser deletada
	 */
	public void delete(int codigo) {
		this.mapProdutos.remove(codigo);
	}
}
