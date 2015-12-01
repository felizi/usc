package br.com.usc.uml.exerc03;

import br.com.usc.uml.exerc03.tipopagamento.CartaoCredito;
import br.com.usc.uml.exerc03.tipopagamento.CartaoDebito;
import br.com.usc.uml.exerc03.tipopagamento.Cheque;

public class Exerc03 {

	public static void main(String[] args) {
		double valor = 18224.27;

		Pagamento pgCartaoCredito = new Pagamento(new CartaoCredito(), valor);
		pgCartaoCredito.calcularValor();
		String valorCartaoCreditoFormatado = pgCartaoCredito.valorFormatado();
		System.out.println(valorCartaoCreditoFormatado);

		Pagamento pagCheque = new Pagamento(new Cheque(), valor);
		pagCheque.calcularValor();
		String valorChequeFormatado = pagCheque.valorFormatado();
		System.out.println(valorChequeFormatado);

		Pagamento pagCartaoDebito = new Pagamento(new CartaoDebito(), valor);
		pagCartaoDebito.calcularValor();
		String valorCartaoDebitoFormatado = pagCartaoDebito.valorFormatado();
		System.out.println(valorCartaoDebitoFormatado);
	}
}
