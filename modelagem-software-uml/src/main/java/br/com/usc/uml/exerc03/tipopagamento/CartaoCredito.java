package br.com.usc.uml.exerc03.tipopagamento;

public class CartaoCredito implements TipoPagamentoInterface {

	public int getDiasFaturamento() {
		return 5;
	}

	public double getPercFinanceiraPaga() {
		return 2.5;
	}

}
