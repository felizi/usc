package br.usc.poo.exerc.ex03.tipopagamento;

/**
 * Classe modelo do objeto Cheque
 * 
 * @author felizi
 * @version 1.0
 * @since Aula de UML
 *
 */
public class Cheque implements TipoPagamentoInterface {

	/**
	 * Retorna a quantidade de dias do faturamento do cheque
	 * 
	 * @return int - quantidadeDiasFaturamento
	 */
	public int getDiasFaturamento() {
		return 15;
	}

	/**
	 * Retorna a percentagem financeira paga do cheque
	 * 
	 * @return double - percFinanceiraPaga
	 */
	public double getPercFinanceiraPaga() {
		return 5.5;
	}
}
