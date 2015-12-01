package br.usc.sistema.service;

import java.text.NumberFormat;
import java.util.Locale;

public class PagamentoService {

	private TipoPagamentoInterface tipoPagamento;
	private double valor;

	public PagamentoService(TipoPagamentoInterface tipoPagamento, double valor) {
		this.tipoPagamento = tipoPagamento;
		this.valor = valor;
	}
	
	public double calcularValor(){
		this.valor = this.valor + (this.valor * this.tipoPagamento.getPercFinanceiraPaga() / 100);
		return this.valor; 
	}
	
	public String valorFormatado(){
		return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valor);
	}
}
