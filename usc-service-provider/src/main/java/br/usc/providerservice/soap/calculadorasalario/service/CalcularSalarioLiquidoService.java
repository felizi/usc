package br.usc.providerservice.soap.calculadorasalario.service;

import javax.jws.WebService;

import br.usc.providerservice.soap.calculadorasalario.bo.CalcularSalarioLiquidoBusiness;

/**
 * Classe de Serviço - CalcularService
 */
@WebService(endpointInterface = "br.usc.providerservice.soap.calculadorasalario.service.CalcularSalarioLiquidoServiceInterface")
public class CalcularSalarioLiquidoService implements CalcularSalarioLiquidoServiceInterface {
	/**
	 * Contrato
	 */
	public double executar(double salarioBruto) {
		return new CalcularSalarioLiquidoBusiness().executar(salarioBruto);
	}
}
