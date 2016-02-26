package br.usc.poo.exerc.ex03.tipopagamento;

/**
 * Classe modelo do objeto CartaoDebito
 * 
 * @author felizi
 * @version 1.0
 * @since Aula de UML
 *
 */
public class CartaoDebito implements TipoPagamentoInterface {

	/**
	 * Retorna a quantidade de dias do faturamento do cartão de débito
	 * 
	 * @return int - quantidadeDiasFaturamento
	 */
	public int getDiasFaturamento() {
		return 1;
	}

	/**
	 * Retorna a percentagem financeira paga do cartão de débito
	 * 
	 * @return double - percFinanceiraPaga
	 */
	public double getPercFinanceiraPaga() {
		return 0.75;
	}

}
