package br.usc.designpatterns.atividade04.components;

public abstract class Memory {
	private long mb;

	public Memory(long mb) {
		super();
		this.mb = mb;
	}

	public long getMb() {
		return mb;
	}

	public abstract double getPrice();

}
