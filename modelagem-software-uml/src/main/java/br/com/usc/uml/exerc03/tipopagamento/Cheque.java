package br.com.usc.uml.exerc03.tipopagamento;

public class Cheque implements TipoPagamentoInterface {
	
	public int getDiasFaturamento() {
		return 15;
	}

	public double getPercFinanceiraPaga() {
		return 5.5;
	}
}
