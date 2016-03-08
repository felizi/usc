package br.usc.providerservice.soap.calculadora.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Interface de Serviço - ICalcularService
 */
@WebService
public interface CalculadoraServiceInterface {
	/**
	 * Contrato - somar
	 */
	@WebMethod
	public double somar(double a, double b);

	/**
	 * Contrato – subtrair
	 */
	@WebMethod
	public double subtrair(double a, double b);
	
	/**
	 * Contrato – multiplicar
	 */
	@WebMethod
	public double multiplicar(double a, double b);
	
	/**
	 * Contrato – dividir
	 */
	@WebMethod
	public double dividir(double a, double b);
}
