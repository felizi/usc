package br.usc.sistema.service.impl;

import br.usc.sistema.service.TipoPagamentoInterface;

public class CartaoCredito implements TipoPagamentoInterface {

	public int getDiasFaturamento() {
		return 5;
	}

	public double getPercFinanceiraPaga() {
		return 2.5;
	}

}
