package br.com.usc.uml.exerc03.tipopagamento;

public class CartaoDebito implements TipoPagamentoInterface {

	public int getDiasFaturamento() {
		return 1;
	}

	public double getPercFinanceiraPaga() {
		return 0.75;
	}

}
