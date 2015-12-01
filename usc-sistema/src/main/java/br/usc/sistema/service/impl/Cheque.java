package br.usc.sistema.service.impl;

import br.usc.sistema.service.TipoPagamentoInterface;

public class Cheque implements TipoPagamentoInterface {
	
	public int getDiasFaturamento() {
		return 15;
	}

	public double getPercFinanceiraPaga() {
		return 5.5;
	}
}
