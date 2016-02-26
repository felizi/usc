package br.usc.poo.exerc.ex04.venda;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import br.usc.poo.exerc.ex04.venda.entity.Produto;
import br.usc.poo.exerc.ex04.venda.entity.Venda;
import br.usc.poo.exerc.ex04.venda.entity.Vendedor;
import br.usc.poo.exerc.ex04.venda.enums.OperadorSentencialEnum;

public class VendaPredicateQuery {

	private List<Venda> vendas;

	public VendaPredicateQuery(List<Venda> vendas) {
		this.vendas = vendas;
	}

	private boolean verificarValor(double valorUm, OperadorSentencialEnum operadorSentencial, double valorDois) {
		switch (operadorSentencial) {
		case IGUAL:
			return valorUm == valorDois;
		case MAIOR:
			return valorUm > valorDois;
		case MAIOR_IGUAL:
			return valorUm >= valorDois;
		case MENOR:
			return valorUm < valorDois;
		case MENOR_IGUAL:
			return valorUm <= valorDois;
		default:
			return false;
		}
	}

	private int obterTotalVendasRealiadasMes(int mes) {
		/**
		 * Predicate - Filtrar vendas realizadas no mês informado
		 */
		Predicate<Venda> vendasRealizadasMesPredicate = v -> {
			Calendar instance = Calendar.getInstance();
			instance.setTime(v.getData());
			int month = instance.get(Calendar.MONTH);
			if (month == mes) {
				return true;
			}
			return false;
		};

		/**
		 * Query
		 */
		List<Venda> vendasRealizadasMes = vendas.stream().filter(vendasRealizadasMesPredicate).collect(Collectors.toList());
		return vendasRealizadasMes.size();
	}

	private int obterTotalVendasRealizadasVendedor(String nome) {
		/**
		 * Predicate - Filtrar vendas realizadas por vendedor
		 */
		Predicate<Venda> vendasPorVendedor = v -> v.getVendedor().getNome().equalsIgnoreCase(nome);

		/**
		 * Query
		 */
		List<Venda> vendasRealizadasVendedor = vendas.stream().filter(vendasPorVendedor).collect(Collectors.toList());

		return vendasRealizadasVendedor.size();
	}

	private int obterTotalVendasValorProduto(OperadorSentencialEnum operadorSentencial, double valor) {
		/**
		 * Predicate - Filtrar vendas realizadas por vendedor
		 */
		Predicate<Produto> produtoPredicate = p -> verificarValor(p.getValor(), operadorSentencial, valor);
		Predicate<Venda> vendaPredicate = v -> v.getProdutos().stream().filter(produtoPredicate).collect(Collectors.toList()).size() > 0;

		/**
		 * Query
		 */
		
		List<Venda> vendasRealizadasVendedor = vendas.stream().filter(vendaPredicate).collect(Collectors.toList());

		return vendasRealizadasVendedor.size();
	}

	public static void main(String[] args) {
		List<Venda> vendas = new ArrayList<>();

		Calendar instance = Calendar.getInstance();

		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto(1, "Videogame", 553, 10));
		produtos.add(new Produto(2, "Celular", 124, 5));
		produtos.add(new Produto(3, "Notebook", 100, 3));
		produtos.add(new Produto(4, "TV", 300, 12));
		instance.set(Calendar.MONTH, 2);
		Vendedor vendedor = new Vendedor("Daniel");
		vendas.add(new Venda(1, vendedor, instance.getTime(), produtos));
		
		produtos = new ArrayList<>();
		produtos.add(new Produto(1, "Videogame", 999, 10));
		produtos.add(new Produto(2, "Celular", 999, 5));
		produtos.add(new Produto(3, "Notebook", 999, 3));
		produtos.add(new Produto(4, "TV", 999, 12));
		instance.set(Calendar.MONTH, 5);
		vendas.add(new Venda(2, vendedor, instance.getTime(), produtos));
		
		produtos = new ArrayList<>();
		produtos.add(new Produto(1, "Videogame", 999, 10));
		produtos.add(new Produto(2, "Celular", 999, 5));
		produtos.add(new Produto(3, "Notebook", 999, 3));
		produtos.add(new Produto(4, "TV", 999, 12));
		instance.set(Calendar.MONTH, 7);
		vendas.add(new Venda(3, vendedor, instance.getTime(), produtos));

		produtos = new ArrayList<>();
		produtos.add(new Produto(1, "Videogame", 1800, 10));
		produtos.add(new Produto(2, "Celular", 2540, 5));
		produtos.add(new Produto(3, "Notebook", 5100, 3));
		produtos.add(new Produto(4, "TV", 2300, 12));
		instance.set(Calendar.MONTH, 7);
		vendas.add(new Venda(4, vendedor, instance.getTime(), produtos));

		VendaPredicateQuery vendaPredicateQuery = new VendaPredicateQuery(vendas);
		System.out.println("Total Vendas Realizadas Vendedor: " + vendaPredicateQuery.obterTotalVendasRealizadasVendedor("Daniel"));

		System.out.println("Total Vendas Realizadas no Mês: " + vendaPredicateQuery.obterTotalVendasRealiadasMes(7));
		
		System.out.println("Total Vendas Valor Produto Maior que 1000: " + vendaPredicateQuery.obterTotalVendasValorProduto(OperadorSentencialEnum.MAIOR, 1000));

	}
}
