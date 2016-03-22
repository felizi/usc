package br.usc.poo.sistema.entity;

/**
 * Enum OperadorSentencialEnum.
 */
public enum OperadorSentencialEnum {

	MAIOR(1), MENOR(2), IGUAL(3), MAIOR_IGUAL(4), MENOR_IGUAL(5);

	/** Valor que representa o enum. */
	public int value;

	/**
	 * Instancia um OperadorSentencialEnum através do valor
	 *
	 * @param value the value
	 */
	private OperadorSentencialEnum(int value) {
		this.value = value;
	}

}
