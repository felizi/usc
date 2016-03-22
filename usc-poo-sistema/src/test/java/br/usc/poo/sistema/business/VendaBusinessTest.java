package br.usc.poo.sistema.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.usc.poo.sistema.business.impl.ProdutoBusiness;
import br.usc.poo.sistema.business.impl.VendaBusiness;
import br.usc.poo.sistema.business.impl.VendedorBusiness;
import br.usc.poo.sistema.entity.Produto;
import br.usc.poo.sistema.entity.Vendedor;

public class VendaBusinessTest {
	private static VendaBusiness vendaBusiness;
	private static VendedorBusiness vendedorBusiness;
	private static ProdutoBusiness produtoBusiness;

	private static Vendedor vendedorA;
	private static Vendedor vendedorB;
	private static Vendedor vendedorC;

	@BeforeClass
	public static void setup() {
		VendaBusinessTest.vendaBusiness = VendaBusiness.of();
		VendaBusinessTest.vendedorBusiness = VendedorBusiness.of();
		VendaBusinessTest.produtoBusiness = ProdutoBusiness.of();

		VendaBusinessTest.vendedorA = VendaBusinessTest.vendedorBusiness.inserirVendedor("Vendedor A", 10d);
		VendaBusinessTest.vendedorB = VendaBusinessTest.vendedorBusiness.inserirVendedor("Vendedor B", 7d);
		VendaBusinessTest.vendedorC = VendaBusinessTest.vendedorBusiness.inserirVendedor("Vendedor C", 15d);

		Produto produtoA = VendaBusinessTest.produtoBusiness.inserirProduto("Produto A", 100, 10);
		Produto produtoB = VendaBusinessTest.produtoBusiness.inserirProduto("Produto B", 50, 5);

		List<Produto> produtos = new ArrayList<>();
		produtos.add(produtoA);
		produtos.add(produtoB);

		VendaBusinessTest.vendaBusiness.realizarVenda(vendedorA, Calendar.getInstance().getTime(), produtos);
		VendaBusinessTest.vendaBusiness.realizarVenda(vendedorB, Calendar.getInstance().getTime(), produtos);

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		VendaBusinessTest.vendaBusiness.realizarVenda(vendedorC, calendar.getTime(), produtos);

		calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 5);
		VendaBusinessTest.vendaBusiness.realizarVenda(vendedorC, calendar.getTime(), produtos);

		calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -4);
		VendaBusinessTest.vendaBusiness.realizarVenda(vendedorC, calendar.getTime(), produtos);

		calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -7);
		VendaBusinessTest.vendaBusiness.realizarVenda(vendedorC, calendar.getTime(), produtos);

		calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -7);
		VendaBusinessTest.vendaBusiness.realizarVenda(vendedorC, calendar.getTime(), produtos);

		calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -7);
		VendaBusinessTest.vendaBusiness.realizarVenda(vendedorC, calendar.getTime(), produtos);
	}

	@Test
	public void deveObterComissaoIgual10Porcento() {
		double totalComissaoSobreVendasRealizadasPorDeterminadoVendedor = VendaBusinessTest.vendaBusiness.obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedor(VendaBusinessTest.vendedorA.getCodigo());
		Assert.assertEquals(10d, totalComissaoSobreVendasRealizadasPorDeterminadoVendedor, Double.MIN_NORMAL);
	}

	@Test
	public void deveObterComissaoIgual7Porcento() {
		double totalComissaoSobreVendasRealizadasPorDeterminadoVendedor = VendaBusinessTest.vendaBusiness.obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedor(VendaBusinessTest.vendedorB.getCodigo());
		Assert.assertEquals(7d, totalComissaoSobreVendasRealizadasPorDeterminadoVendedor, Double.MIN_NORMAL);
	}

	@Test
	public void deveObterTotalVendasRealizadasMesAtual() {
		double totalVendasRealizadasMes = VendaBusinessTest.vendaBusiness.obterTotalVendasRealizadasMes(Calendar.getInstance().get(Calendar.MONTH));
		Assert.assertEquals(300d, totalVendasRealizadasMes, Double.MIN_NORMAL);
	}

	@Test
	public void deveObterTotalVendasPorDeterminadoVendedor() {
		double totalVendasRealizadasMes = VendaBusinessTest.vendaBusiness.obterTotalVendasRealizadasPorDeterminadoVendedor(VendaBusinessTest.vendedorC.getCodigo());
		Assert.assertEquals(900d, totalVendasRealizadasMes, Double.MIN_NORMAL);
	}

	@Test
	public void deveObterTotalComissaoSobreVendasRealizadasDeterminadoVendedor() {
		double totalComissaoVendasRealizadasVendedor = VendaBusinessTest.vendaBusiness.obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedor(VendaBusinessTest.vendedorC.getCodigo());
		Assert.assertEquals(90d, totalComissaoVendasRealizadasVendedor, Double.MIN_NORMAL);
	}

	@Test
	public void deveObterTotalComissaoSobreVendasRealizadasDeterminadoVendedorMes() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -7);
		double totalComissaoVendasRealizadasVendedor = VendaBusinessTest.vendaBusiness.obterTotalComissaoSobreVendasRealizadasPorDeterminadoVendedorMes(VendaBusinessTest.vendedorC.getCodigo(), calendar.get(Calendar.MONTH));
		Assert.assertEquals(60d, totalComissaoVendasRealizadasVendedor, Double.MIN_NORMAL);
	}
}
