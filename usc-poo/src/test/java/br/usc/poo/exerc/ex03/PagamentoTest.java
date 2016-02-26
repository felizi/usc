package br.usc.poo.exerc.ex03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.usc.poo.exerc.ex03.tipopagamento.CartaoCredito;
import br.usc.poo.exerc.ex03.tipopagamento.CartaoDebito;
import br.usc.poo.exerc.ex03.tipopagamento.Cheque;
import br.usc.poo.exerc.ex03.tipopagamento.exception.TipoPagamentoInvalidoException;

public class PagamentoTest {

	private final double VALOR = 10;
	private final double VALOR_CARTAO_CREDITO = 10.25;
	private final double VALOR_CARTAO_DEBITO = 10.075;
	private final double VALOR_CHEQUE = 10.55;
	
	private final String VALOR_CARTAO_CREDITO_FORMATADO = "R$ 10,25";
	private final String VALOR_CARTAO_DEBITO_FORMATADO = "R$ 10,07";
	private final String VALOR_CHEQUE_FORMATADO = "R$ 10,55";
	
	private Pagamento pagamentoCartaoCredito;
	private Pagamento pagamentoCartaoDebito;
	private Pagamento pagamentoCheque;

	@Before
	public void setup() throws TipoPagamentoInvalidoException {
		this.pagamentoCartaoCredito = new Pagamento(new CartaoCredito(), VALOR);
		this.pagamentoCartaoDebito = new Pagamento(new CartaoDebito(), VALOR);
		this.pagamentoCheque = new Pagamento(new Cheque(), VALOR);
	}

	@Test
	public void testPagamentoCartaoCredito() {
		double valor = this.pagamentoCartaoCredito.calcularValor();
		Assert.assertEquals(VALOR_CARTAO_CREDITO, valor, 0);
	}
	
	@Test
	public void testPagamentoCartaoDebito() {
		double valor = this.pagamentoCartaoDebito.calcularValor();
		Assert.assertEquals(VALOR_CARTAO_DEBITO, valor, 0);
	}
	
	@Test
	public void testPagamentoCheque() {
		double valor = this.pagamentoCheque.calcularValor();
		Assert.assertEquals(VALOR_CHEQUE, valor, 0);
	}
	
	@Test
	public void testPagamentoCartaoCreditoFormatado() {
		String valorFormatado = this.pagamentoCartaoCredito.valorFormatado();
		Assert.assertEquals(VALOR_CARTAO_CREDITO_FORMATADO, valorFormatado);
	}
	
	@Test
	public void testPagamentoCartaoDebitoFormatado() {
		String valorFormatado = this.pagamentoCartaoDebito.valorFormatado();
		Assert.assertEquals(VALOR_CARTAO_DEBITO_FORMATADO, valorFormatado);
	}
	
	@Test
	public void testPagamentoChequeFormatado() {
		String valorFormatado = this.pagamentoCheque.valorFormatado();
		Assert.assertEquals(VALOR_CHEQUE_FORMATADO, valorFormatado);
	}
	

/*	double valor = 18224.27;

	try {
		Pagamento pgCartaoCredito = new Pagamento(new CartaoCredito(), valor);
		pgCartaoCredito.calcularValor();
		String valorCartaoCreditoFormatado = pgCartaoCredito.valorFormatado();
		System.out.println(valorCartaoCreditoFormatado);
	} catch (TipoPagamentoInvalidoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		Pagamento pagCheque = new Pagamento(new Cheque(), valor);
		pagCheque.calcularValor();
		String valorChequeFormatado = pagCheque.valorFormatado();
		System.out.println(valorChequeFormatado);
	} catch (TipoPagamentoInvalidoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		Pagamento pagCartaoDebito = new Pagamento(new CartaoDebito(), valor);
		pagCartaoDebito.calcularValor();
		String valorCartaoDebitoFormatado = pagCartaoDebito.valorFormatado();
		System.out.println(valorCartaoDebitoFormatado);
	} catch (TipoPagamentoInvalidoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
*/

}
