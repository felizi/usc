package br.usc.poo.exerc.ex03;

import java.text.NumberFormat;
import java.util.Locale;

import br.usc.poo.exerc.ex03.tipopagamento.TipoPagamentoInterface;
import br.usc.poo.exerc.ex03.tipopagamento.exception.TipoPagamentoInvalidoException;

/**
 * Classe modelo do objeto Pagamento
 * 
 * @author felizi
 * @version 1.0
 * @since Aula de UML
 *
 */
public class Pagamento {

	private TipoPagamentoInterface tipoPagamento;
	private double valor;

	/**
	 * Construtor da classe Pagamento
	 * 
	 * @param TipoPagamentoInterface - tipoPagamento
	 * @param double - valor
	 * 
	 * @throws TipoPagamentoInvalidoException
	 */
	public Pagamento(TipoPagamentoInterface tipoPagamento, double valor) throws TipoPagamentoInvalidoException {
		if (tipoPagamento == null) {
			throw new TipoPagamentoInvalidoException();
		}
		
		this.tipoPagamento = tipoPagamento;
		this.valor = valor;
	}

	/**
	 * Retorna o calculo do valor somado com a multiplicação do valor pela percentagem financeira paga divida
	 * 
	 * @return double - valor
	 */
	public double calcularValor() {
		return this.valor + (this.valor * this.tipoPagamento.getPercFinanceiraPaga() / 100);
	}

	/**
	 * Retorna o valor formatado na moeda pt-BR
	 * 
	 * @return String - valorFormatado
	 */
	public String valorFormatado() {
		return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(calcularValor());
	}
}
