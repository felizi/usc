package br.usc.providerservice.soap.calculadora.service;

import javax.jws.WebService;

import br.usc.providerservice.soap.calculadora.bo.CalculadoraBusiness;

/**
 * Classe de Serviço - CalcularService
 */
@WebService(endpointInterface = "br.usc.providerservice.soap.calculadora.service.CalculadoraServiceInterface")
public class CalculadoraService implements CalculadoraServiceInterface {
	/**
	 * Contrato - somar
	 */
	public double somar(double a, double b) {
		return new CalculadoraBusiness().somar(a, b);
	}

	/**
	 * Contrato – subtrair
	 */
	public double subtrair(double a, double b) {
		return new CalculadoraBusiness().subtrair(a, b);
	}

	/**
	 * Contrato – multiplicar
	 */
	public double multiplicar(double a, double b) {
		return new CalculadoraBusiness().multiplicar(a, b);
	}

	/**
	 * Contrato – dividir
	 */
	public double dividir(double a, double b) {
		return new CalculadoraBusiness().dividir(a, b);
	}
}
