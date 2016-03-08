package br.usc.providerservice.soap.calculadorasalario.domain;

public class IRRF {

	public static IRRF of() {
		return new IRRF();
	}

	public double obterDescontoIRRF(double salarioComDescontoINSS) {
		double porcentagemIRRF = obterPorcentagemIRRF(salarioComDescontoINSS);
		double deducao = obterValorParaDeducao(salarioComDescontoINSS);
		double aliquota = calcularAliquota(salarioComDescontoINSS, porcentagemIRRF);

		return calcularAliquotaComDeducao(aliquota, deducao);
	}

	private double calcularAliquota(double salario, double percent) {
		return salario * percent;
	}

	private double calcularAliquotaComDeducao(double aliquota, double deducao) {
		return aliquota - deducao;
	}

	private double obterPorcentagemIRRF(double salario) {
		if (salario <= 1903.98) {
			return 1;
		} else if (salario >= 1903.99 && salario <= 2826.65) {
			return 0.075;
		} else if (salario >= 2826.66 && salario <= 3751.05) {
			return 0.15;
		} else if (salario >= 3751.056 && salario <= 4664.68) {
			return 0.225;
		} else if (salario > 4664.68) {
			return 0.275;
		}
		return 1;
	}

	private double obterValorParaDeducao(double salario) {
		if (salario <= 1903.98) {
			return 0;
		} else if (salario >= 1903.99 && salario <= 2826.65) {
			return 142.80;
		} else if (salario >= 2826.66 && salario <= 3751.05) {
			return 354.80;
		} else if (salario >= 3751.056 && salario <= 4664.68) {
			return 636.13;
		} else if (salario > 4664.68) {
			return 869.36;
		}
		return 0;
	}
}
