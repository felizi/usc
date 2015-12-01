package br.com.usc.uml.exerc03;

import java.text.NumberFormat;
import java.util.Locale;

import br.com.usc.uml.exerc03.tipopagamento.TipoPagamentoInterface;

public class Pagamento {

	private TipoPagamentoInterface tipoPagamento;
	private double valor;

	public Pagamento(TipoPagamentoInterface tipoPagamento, double valor) {
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
