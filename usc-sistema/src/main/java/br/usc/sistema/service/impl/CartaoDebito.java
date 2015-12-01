package br.usc.sistema.service.impl;

import br.usc.sistema.service.TipoPagamentoInterface;

public class CartaoDebito implements TipoPagamentoInterface {

	public int getDiasFaturamento() {
		return 1;
	}

	public double getPercFinanceiraPaga() {
		return 0.75;
	}

}
