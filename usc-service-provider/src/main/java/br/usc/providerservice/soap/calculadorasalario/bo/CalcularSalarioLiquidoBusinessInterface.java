package br.usc.providerservice.soap.calculadorasalario.bo;

/**
 * Interface de Negócio
 */
public interface CalcularSalarioLiquidoBusinessInterface {
	/**
	 * Contrato - Calcular o salário líquido
	 */
	public double executar(double salarioBruto);
}
