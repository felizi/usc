package br.usc.providerservice.soap.calculadorasalario.domain;

public class SalarioBruto {
	private INSS inss;
	private IRRF irrf;

	private SalarioBruto(INSS inss, IRRF irrf) {
		super();
		this.inss = inss;
		this.irrf = irrf;
	}

	public static SalarioBruto of(INSS inss, IRRF irrf) {
		return new SalarioBruto(inss, irrf);
	}

	public double calcularSalarioLiquido(double salarioBruto) {
		return salarioBruto - (inss.obterDescontoINSS(salarioBruto) + irrf.obterDescontoIRRF(calcularSalarioComDescontoINSS(salarioBruto)));
	}

	private double calcularSalarioComDescontoINSS(double salarioBruto) {
		return salarioBruto - inss.obterDescontoINSS(salarioBruto);
	}
}
