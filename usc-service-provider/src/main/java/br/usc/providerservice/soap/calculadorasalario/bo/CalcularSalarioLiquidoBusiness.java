package br.usc.providerservice.soap.calculadorasalario.bo;

import br.usc.providerservice.soap.calculadorasalario.domain.INSS;
import br.usc.providerservice.soap.calculadorasalario.domain.IRRF;
import br.usc.providerservice.soap.calculadorasalario.domain.SalarioBruto;

/**
 * 
 * Classe de Negócio - CalcularBusiness
 */
public class CalcularSalarioLiquidoBusiness implements CalcularSalarioLiquidoBusinessInterface {

	public double executar(double salarioBruto) {
		return SalarioBruto.of(INSS.of(), IRRF.of()).calcularSalarioLiquido(salarioBruto);
	}

}
