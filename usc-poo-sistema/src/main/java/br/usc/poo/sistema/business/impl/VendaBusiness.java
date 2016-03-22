package br.usc.poo.sistema.business.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import br.usc.poo.sistema.business.VendaBusinessInterface;
import br.usc.poo.sistema.entity.OperadorSentencialEnum;
import br.usc.poo.sistema.entity.Produto;
import br.usc.poo.sistema.entity.Venda;
import br.usc.poo.sistema.entity.Vendedor;
import br.usc.poo.sistema.repository.VendaRepository;

/**
 * Classe VendaBusiness.
 */
public class VendaBusiness implements VendaBusinessInterface {
	private VendaRepository vendaRepository;

	/**
	 * Construtor
	 *
	 * @param vendaRepository the venda repository
	 */
	private VendaBusiness(VendaRepository vendaRepository) {
		super();
		this.vendaRepository = vendaRepository;
	}

	/**
	 * Método construtor
	 * 
	 * @return VendaBusiness
	 */
	public static VendaBusiness of() {
		return new VendaBusiness(VendaRepository.of());
	}

	/* (non-Javadoc)
	 * @see br.usc.poo.sistema.business.VendaBusinessInterface#realizarVenda(br.usc.poo.sistema.entity.Vendedor, java.util.Date, java.util.List)
	 */
	@Override
	public Venda realizarVenda(Vendedor vendedor, Date date, List<Produto> produtos) {
		return this.vendaRepository.create(vendedor, date, produtos);
	}

	/**
	 * Verificar valor.
	 *
	 * @param valorUm the valor um
	 * @param operadorSentencial the operador sentencial
	 * @param valorDois the valor dois
	 * @return true, if successful
	 */
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

	/**
	 * Obter vendas realiadas mes.
	 *
	 * @param mes the mes
	 * @return the list
	 */
	@Override
	public List<Venda> obterVendasRealizadasMes(int mes) {
		/**
		 * Predicate - Filtrar vendas realizadas no mês informado
		 */
		Predicate<Venda> vendasRealizadasMesPredicate = v -> {
			return true;
		};
		if (mes >= 0 && mes <= 11) {
			vendasRealizadasMesPredicate = v -> {
				Calendar instance = Calendar.getInstance();
				instance.setTime(v.getData());
				int month = instance.get(Calendar.MONTH);
				if (month == mes) {
					return true;
				}
				return false;
			};
		}

		/**
		 * Query
		 */
		List<Venda> vendasRealizadasMes = this.vendaRepository.readAll().stream().filter(vendasRealizadasMesPredicate).collect(Collectors.toList());

		return vendasRealizadasMes;
	}

	/* (non-Javadoc)
	 * @see br.usc.poo.sistema.business.VendaBusinessInterface#obterQuantidadeVendasPorValorProduto(br.usc.poo.sistema.entity.OperadorSentencialEnum, double)
	 */
	@Override
	public int obterQuantidadeVendasPorValorProduto(OperadorSentencialEnum operadorSentencial, double valor) {
		/**
		 * Predicate - Filtrar vendas realizadas por vendedor
		 */
		Predicate<Produto> produtoPredicate = p -> verificarValor(p.getValor(), operadorSentencial, valor);
		Predicate<Venda> vendaPredicate = v -> v.getProdutos().stream().filter(produtoPredicate).collect(Collectors.toList()).size() > 0;

		/**
		 * Query
		 */
		List<Venda> vendasRealizadasVendedor = this.vendaRepository.readAll().stream().filter(vendaPredicate).collect(Collectors.toList());

		return vendasRealizadasVendedor.size();
	}

	/**
	 * Obtém o total de vendas realizadas em um determinado mês.
	 *
	 * @param mes the mes
	 * @return the double
	 */
	@Override
	public double obterTotalVendasRealizadasMes(int mes) {
		List<Venda> vendasRealizadasMes = obterVendasRealizadasMes(mes);

		/**
		 * Query
		 */
		return vendasRealizadasMes.stream().flatMap(venda -> venda.getProdutos().stream()).collect(Collectors.toList()).stream().map(p -> p.getValor()).reduce(0d, (totalVendas, valorProduto) -> totalVendas + valorProduto);
	}

	/* (non-Javadoc)
	 * @see br.usc.poo.sistema.business.VendaBusinessInterface#obterVendasRealizadasVendedor(int, java.util.List)
	 */
	@Override
	public List<Venda> obterVendasRealizadasVendedor(int codigoVendedor, List<Venda> vendas) {
		/**
		 * Predicate - Filtrar vendas realizadas por vendedor
		 */
		Predicate<Venda> vendasPorVendedor = v -> v.getVendedor().getCodigo() == codigoVendedor;

		/**
		 * Query
		 */
		List<Venda> vendasRealizadasVendedor = vendas.stream().filter(vendasPorVendedor).collect(Collectors.toList());

		return vendasRealizadasVendedor;
	}

	/* (non-Javadoc)
	 * @see br.usc.poo.sistema.business.VendaBusinessInterface#obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedorMes(int, int)
	 */
	@Override
	public double obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedorMes(int codigoVendedor, int mes) {
		List<Venda> vendasRealizadasPorVendedorMes = obterVendasRealizadasVendedor(codigoVendedor, obterVendasRealizadasMes(mes));

		/**
		 * Query
		 */
		Double totalComissaoVendasRealizadasPorDeterminadoVendedorMes = vendasRealizadasPorVendedorMes.stream().map(v -> v.getVendedor().getPercentualComissao()).reduce(0d, (totalComissao, comissao) -> totalComissao + comissao);
		return totalComissaoVendasRealizadasPorDeterminadoVendedorMes;
	}

	/* (non-Javadoc)
	 * @see br.usc.poo.sistema.business.VendaBusinessInterface#obterTotalVendasRealizadasPorDeterminadoVendedorMes(int, int)
	 */
	@Override
	public double obterTotalVendasRealizadasPorDeterminadoVendedorMes(int codigoVendedor, int mes) {
		List<Venda> vendasRealizadasPorVendedorMes = obterVendasRealizadasVendedor(codigoVendedor, obterVendasRealizadasMes(mes));

		/**
		 * Query
		 */
		Double totalVendasRealizadasPorDeterminadoVendedorMes = vendasRealizadasPorVendedorMes.stream().map(v -> v.somarTotalVendas()).reduce(0d, (totalComissao, comissao) -> totalComissao + comissao);
		return totalVendasRealizadasPorDeterminadoVendedorMes;
	}

	/* (non-Javadoc)
	 * @see br.usc.poo.sistema.business.VendaBusinessInterface#obterTotalVendasRealizadasPorDeterminadoVendedor(int)
	 */
	@Override
	public double obterTotalVendasRealizadasPorDeterminadoVendedor(int codigoVendedor) {
		return obterTotalVendasRealizadasPorDeterminadoVendedorMes(codigoVendedor, -1);
	}

	/* (non-Javadoc)
	 * @see br.usc.poo.sistema.business.VendaBusinessInterface#obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedor(int)
	 */
	@Override
	public double obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedor(int codigoVendedor) {
		return obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedorMes(codigoVendedor, -1);
	}
}
