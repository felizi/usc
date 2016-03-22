package br.usc.poo.sistema.repository;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import br.usc.poo.sistema.entity.Vendedor;
import br.usc.poo.sistema.repository.generator.IdGenerator;

public class VendedorRepository {
	private static VendedorRepository vendedorRepositorySingleton;

	private IdGenerator idGenerator;
	private ConcurrentHashMap<Integer, Vendedor> mapVendedores = new ConcurrentHashMap<>();

	private VendedorRepository(IdGenerator idGenerator, ConcurrentHashMap<Integer, Vendedor> mapVendedores) {
		super();
		this.idGenerator = idGenerator;
		this.mapVendedores = mapVendedores;
	}

	public static VendedorRepository of() {
		if (VendedorRepository.vendedorRepositorySingleton == null) {
			VendedorRepository.vendedorRepositorySingleton = new VendedorRepository(IdGenerator.of(), new ConcurrentHashMap<>());
		}
		return VendedorRepository.vendedorRepositorySingleton;
	}

	public Vendedor create(String nome, double percentualComissao) {
		int codigo = idGenerator.generate();
		Vendedor vendedor = new Vendedor(codigo, nome, percentualComissao);
		this.mapVendedores.put(codigo, vendedor);
		return vendedor;
	}

	public List<Vendedor> readAll() {
		return Collections.unmodifiableList(this.mapVendedores.entrySet().stream().map(v -> v.getValue()).collect(Collectors.toList()));
	}

	public Vendedor read(int codigo) {
		return this.mapVendedores.get(codigo);
	}

	public List<Vendedor> read(String nome) {
		Predicate<Vendedor> predicate = p -> p.getNome().toUpperCase().contains(nome.toUpperCase());
		return Collections.unmodifiableList(this.mapVendedores.values().stream().filter(predicate).collect(Collectors.toList()));
	}

	public Vendedor update(int codigo, String nome, double percentualComissao) {
		Vendedor vendedor = new Vendedor(codigo, nome, percentualComissao);
		this.mapVendedores.put(codigo, vendedor);
		return vendedor;
	}

	public void delete(int codigo) {
		this.mapVendedores.remove(codigo);
	}
}
