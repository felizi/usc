package br.usc.providerservice.soap.calculadorasalario.domain;

public class INSS {
	private static double SALARIO_TETO_INSS = 5189.82;
	private static double VALOR_MAXIMO_INSS = 570.88;

	public static INSS of() {
		return new INSS();
	}

	public double obterDescontoINSS(double salarioBruto) {
		if (salarioBruto > SALARIO_TETO_INSS) {
			return salarioBruto * VALOR_MAXIMO_INSS;
		}
		return salarioBruto * obterINSS(salarioBruto);
	}

	public double obterINSS(double salarioBruto) {
		if (salarioBruto <= 1556.94) {
			return 0.08;
		} else if (salarioBruto >= 1556.95 && salarioBruto <= 2594.92) {
			return 0.09;
		} else if (salarioBruto >= 2594.93 && salarioBruto <= 5189.82) {
			return 0.11;
		}
		throw new RuntimeException("Valor fora das faixas de INSS");
	}
}