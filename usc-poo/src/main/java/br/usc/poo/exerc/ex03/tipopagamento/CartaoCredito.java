package br.usc.poo.exerc.ex03.tipopagamento;

/**
 * Classe modelo do objeto CartaoCredito
 * 
 * @author felizi
 * @version 1.0
 * @since Aula de UML
 *
 */
public class CartaoCredito implements TipoPagamentoInterface {

	/**
	 * Retorna a quantidade de dias do faturamento do cartão de crédito
	 * 
	 * @return int - quantidadeDiasFaturamento
	 */
	public int getDiasFaturamento() {
		return 5;
	}

	/**
	 * Retorna a percentagem financeira paga do cartão de crédito
	 * 
	 * @return double - percFinanceiraPaga
	 */
	public double getPercFinanceiraPaga() {
		return 2.5;
	}

}
