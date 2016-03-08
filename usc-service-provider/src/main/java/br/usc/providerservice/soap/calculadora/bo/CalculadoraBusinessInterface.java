package br.usc.providerservice.soap.calculadora.bo;

/**
 * Interface de Negócio - CalcularBusinessInterface
 */
public interface CalculadoraBusinessInterface {
	/**
	 * Contrato - somar
	 */
	public double somar(double a, double b);

	/**
	 * Contrato - subtrair
	 */
	public double subtrair(double a, double b);
	
	/**
	 * Contrato - multiplicar
	 */
	public double multiplicar(double a, double b);
	
	/**
	 * Contrato - dividir
	 */
	public double dividir(double a, double b);
}
