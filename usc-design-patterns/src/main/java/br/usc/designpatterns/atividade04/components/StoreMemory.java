package br.usc.designpatterns.atividade04.components;

public class StoreMemory extends Memory {
	public StoreMemory(long mb) {
		super(mb);
	}

	@Override
	public double getPrice() {
		return super.getMb() * 0.0005;
	}
}
