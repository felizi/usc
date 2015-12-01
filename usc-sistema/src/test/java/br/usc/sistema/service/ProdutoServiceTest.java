package br.usc.sistema.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.usc.sistema.entity.Produto;
import br.usc.sistema.exception.InvalidParameterException;
import br.usc.sistema.exception.InvalidProductException;
import br.usc.sistema.exception.ProductDoesNotExistException;

public class ProdutoServiceTest {
	private ProdutoService service;
	private Produto produto1;
	private Produto produto2;
	private Produto produto3;
	private Produto produto4;
	private Produto produto5;

	@Before
	public void setup() {
		service = new ProdutoService();

		produto1 = new Produto("Sony Playstation 4", "Sistema PlayStation 4 500GB ; Controle Dualshock 4; Cabo HDMI; Cabo de força AC; Fone de ouvido com fio; Cabo USB", 2000, 20);
		produto2 = new Produto("Samsung Galaxy S6", "Aparelho celular Samsung Galaxy S6, bateria, carregador, fone de ouvido e cabo USB", 2599, 15);
		produto3 = new Produto("SmartTV LG 55\" HDTV", "1 TV, 1 Controle Remoto, 2 Pilhas AA, 1 Cabo de Força, 1 Manual de instruções, 1 Extensão de Infra-Vermelho", 5599, 10);
		produto4 = new Produto("Notebook Samsung ATIV Book 2 Intel Core i5 8GB 1TB Tela LED 15.6'' Windows 8.1 - Branco", "1 computador portátil, 1 fonte adaptadora, guias de usuário e certificado de garantia", 2259, 30);
		produto5 = null;
	}

	@Test
	public void testServiceIsNotNull() {
		assertNotNull(service);
	}

	@Test
	public void testProdutoIsNotNull() throws InvalidProductException {
		Produto produto = service.adicionar(produto1);
		assertNotNull(produto);
	}

	@Test
	public void testProdutoIdIsNotNull() throws InvalidProductException {
		Produto produto = service.adicionar(produto2);
		assertNotNull(produto.getId());
	}

	@Test
	public void testPesquisarProdutoPorId() throws InvalidProductException, InvalidParameterException {
		List<Produto> pesquisarProdutos = service.pesquisarProdutos("Playstation");
		assertEquals(1, pesquisarProdutos.size());
	}

	@Test(expected = InvalidParameterException.class)
	public void testPesquisarProdutosNull() throws InvalidProductException, InvalidParameterException {
		service.pesquisarProdutos(null);
	}

	@Test(expected = InvalidParameterException.class)
	public void testPesquisarProdutosZero() throws InvalidProductException, InvalidParameterException {
		service.pesquisarProdutos(0);
	}

	@Test(expected = InvalidParameterException.class)
	public void testPesquisarProdutosNegative() throws InvalidProductException, InvalidParameterException {
		service.pesquisarProdutos(-1);
	}

	@Test
	public void testAdicionarExcluir() throws InvalidProductException, InvalidParameterException {
		Produto adicionar = service.adicionar(produto3);
		boolean excluir = service.excluir(adicionar.getId());
		assertTrue(excluir);
	}

	@Test
	public void testAdicionarAlterar() throws InvalidProductException, InvalidParameterException, ProductDoesNotExistException {
		Produto adicionar = service.adicionar(produto4);
		adicionar.setPreco(1234);
		adicionar.setQuantidade(99);
		adicionar.setDescricao("Descrição alterada!!!!");
		adicionar.setNome("Nome alterado!!!");
		service.alterarProduto(adicionar);
	}

	@Test(expected = ProductDoesNotExistException.class)
	public void testAlterarProdutoInexistente() throws InvalidProductException, InvalidParameterException, ProductDoesNotExistException {
		service.alterarProduto(new Produto(null, null, 0, 0));
	}

	@Test(expected = InvalidProductException.class)
	public void testAlterarProdutoExistenteInvalido() throws InvalidProductException, InvalidParameterException, ProductDoesNotExistException {
		Produto pesquisarProdutos = service.pesquisarProdutos(1);
		pesquisarProdutos.setNome(null);
		service.alterarProduto(pesquisarProdutos);
	}

	@Test
	public void testAlterarProdutoExistenteValido() throws InvalidProductException, InvalidParameterException, ProductDoesNotExistException {
		service.adicionar(new Produto("Produto para ser alterado", "Descrição para ser alterada", 0, 0));

		List<Produto> pesquisarProdutos = service.pesquisarProdutos("Produto para ser alterado");

		Produto produto = pesquisarProdutos.get(0);

		produto.setNome("Novo produto alterado");
		produto.setDescricao("Descrição do produto alterado");
		produto.setPreco(999);
		produto.setQuantidade(999);

		Produto produtoBaseNaoAlterado = service.pesquisarProdutos(produto.getId());

		assertNotEquals(produtoBaseNaoAlterado.getNome(), "Novo produto alterado");
		assertNotEquals(produtoBaseNaoAlterado.getDescricao(), "Descrição do produto alterado");
		assertNotEquals(produtoBaseNaoAlterado.getPreco(), 999, 0);
		assertNotEquals(produtoBaseNaoAlterado.getQuantidade(), 999);

		service.alterarProduto(produto);

		Produto produtoAlterado = service.pesquisarProdutos(produto.getId());

		assertEquals(produtoAlterado.getNome(), "Novo produto alterado");
		assertEquals(produtoAlterado.getDescricao(), "Descrição do produto alterado");
		assertEquals(produtoAlterado.getPreco(), 999, 0);
		assertEquals(produtoAlterado.getQuantidade(), 999);
	}
	
	@Test
	public void testAdicionarPesquisarExcluirPesquisarProduto() throws InvalidProductException, InvalidParameterException, ProductDoesNotExistException {
		Produto adicionar = service.adicionar(new Produto("Produto para ser excluído 1", "Descrição do produto", 0, 0));
		
		List<Produto> pesquisarProdutos = service.pesquisarProdutos("Produto para ser excluído 1");
		
		assertEquals(1, pesquisarProdutos.size());
		
		boolean excluir = service.excluir(adicionar.getId());
		
		List<Produto> pesquisarProdutosAposExclusao = service.pesquisarProdutos("Produto para ser excluído 1");
		
		assertEquals(0, pesquisarProdutosAposExclusao.size());
		
		assertTrue(excluir);
	}
	
	@Test
	public void testExcluirProduto() throws InvalidProductException, InvalidParameterException, ProductDoesNotExistException {
		Produto adicionar = service.adicionar(new Produto("Produto para ser excluído 2", "Descrição do produto", 0, 0));
		
		boolean excluir = service.excluir(adicionar.getId());
		
		assertTrue(excluir);
	}
}
