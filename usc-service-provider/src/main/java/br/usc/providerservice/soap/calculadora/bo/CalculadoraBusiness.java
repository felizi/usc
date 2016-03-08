package br.usc.providerservice.soap.calculadora.bo;

/**
 * 
 * Classe de Negócio - CalcularBusiness
 */
public class CalculadoraBusiness implements CalculadoraBusinessInterface {

	public double somar(double a, double b) {
		return a + b;
	}

	public double subtrair(double a, double b) {
		return a - b;
	}

	public double multiplicar(double a, double b) {
		return a * b;
	}

	public double dividir(double a, double b) {
		return a / b;
	}

}
