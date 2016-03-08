package br.usc.providerservice.soap.calculadorasalario.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Interface de Serviço
 */
@WebService
public interface CalcularSalarioLiquidoServiceInterface {
	@WebMethod
	public double executar(double salarioBruto);
}
