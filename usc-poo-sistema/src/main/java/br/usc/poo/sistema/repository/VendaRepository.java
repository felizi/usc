package br.usc.poo.sistema.repository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import br.usc.poo.sistema.entity.Produto;
import br.usc.poo.sistema.entity.Venda;
import br.usc.poo.sistema.entity.Vendedor;
import br.usc.poo.sistema.repository.generator.IdGenerator;

/**
 * Classe VendaRepository: camada responsável pela persistência/infra da venda
 */
public class VendaRepository {
	/** Singleton. */
	private static VendaRepository vendaRepositorySingleton;

	private IdGenerator idGenerator;
	private ConcurrentHashMap<Integer, Venda> mapVendas = new ConcurrentHashMap<>();

	/**
	 * Instancia uma nova VendaRepository
	 *
	 * @param idGenerator the id generator
	 * @param mapVendas the map vendas
	 */
	private VendaRepository(IdGenerator idGenerator, ConcurrentHashMap<Integer, Venda> mapVendas) {
		super();
		this.idGenerator = idGenerator;
		this.mapVendas = mapVendas;
	}

	/**
	 * Instancia uma nova VendaRepository
	 *
	 * @return venda repository
	 */
	public static VendaRepository of() {
		if (VendaRepository.vendaRepositorySingleton == null) {
			VendaRepository.vendaRepositorySingleton = new VendaRepository(IdGenerator.of(), new ConcurrentHashMap<>());
		}
		return VendaRepository.vendaRepositorySingleton;
	}

	/**
	 * Cria uma nova Venda
	 *
	 * @param vendedor que está realizando a venda
	 * @param date da venda
	 * @param produtos vendidos
	 * @return venda
	 */
	public Venda create(Vendedor vendedor, Date date, List<Produto> produtos) {
		int codigo = idGenerator.generate();
		Venda venda = new Venda(codigo, vendedor, date, produtos);
		this.mapVendas.put(codigo, venda);
		return venda;
	}

	/**
	 * Pesquisar todas as vendas
	 *
	 * @return todas as vendas
	 */
	public List<Venda> readAll() {
		return Collections.unmodifiableList(this.mapVendas.entrySet().stream().map(v -> v.getValue()).collect(Collectors.toList()));
	}

	/**
	 * Pesquisar uma venda pelo código.
	 *
	 * @param codigo da venda
	 * @return a venda
	 */
	public Venda read(int codigo) {
		return this.mapVendas.get(codigo);
	}

	/**
	 * Atualizar uma venda.
	 *
	 * @param codigo da venda 
	 * @param vendedor da venda
	 * @param date de venda
	 * @param produtos vendidos
	 * @return venda
	 */
	public Venda update(int codigo, Vendedor vendedor, Date date, List<Produto> produtos) {
		Venda venda = new Venda(codigo, vendedor, date, produtos);
		this.mapVendas.put(codigo, venda);
		return venda;
	}

	/**
	 * Excluir uma venda pelo código
	 *
	 * @param codigo do produto a ser excluído
	 */
	public void delete(int codigo) {
		this.mapVendas.remove(codigo);
	}
}
