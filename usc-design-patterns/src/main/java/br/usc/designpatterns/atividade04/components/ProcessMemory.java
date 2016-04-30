package br.usc.designpatterns.atividade04.components;

public class ProcessMemory extends Memory {
	public ProcessMemory(long mb) {
		super(mb);
	}

	@Override
	public double getPrice() {
		return super.getMb() * 0.025;
	}
}
