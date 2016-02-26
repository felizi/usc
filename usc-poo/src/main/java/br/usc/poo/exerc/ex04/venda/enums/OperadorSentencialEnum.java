package br.usc.poo.exerc.ex04.venda.enums;

public enum OperadorSentencialEnum {

	MAIOR(1), MENOR(2), IGUAL(3), MAIOR_IGUAL(4), MENOR_IGUAL(5);

	public int value;

	private OperadorSentencialEnum(int value) {
		this.value = value;
	}

}
