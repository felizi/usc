package br.usc.poo.exerc.ex03.tipopagamento;

/**
 * Interface modelo do para os objetos CartaoCredito, CartaoDebito e Cheque
 * 
 * @author felizi
 * @version 1.0
 * @since Aula de UML
 *
 */
public interface TipoPagamentoInterface {
	
	/**
	 * Determina o retorno quantidade dias faturamento das implementações
	 * 
	 * @return int - quantidadeDiasFaturamento
	 */
	public int getDiasFaturamento();
	
	/**
	 * Determina o retorno percentagem financeira das implementações
	 * 
	 * @return double - percFinanceiraPaga
	 */
	public double getPercFinanceiraPaga();
}
