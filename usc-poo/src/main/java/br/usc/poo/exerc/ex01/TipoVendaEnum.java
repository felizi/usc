package br.usc.poo.exerc.ex01;

public enum TipoVendaEnum {

	BALCAO(1), DELIVERY(2), MESA(3), CARTAO(4), NF_MANUAL(5), AUTO_ATENDIMENTO(6);

	public int value;

	private TipoVendaEnum(int value) {
		this.value = value;
	}
}
