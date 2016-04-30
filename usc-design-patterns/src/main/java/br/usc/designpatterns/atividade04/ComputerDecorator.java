package br.usc.designpatterns.atividade04;

public abstract class ComputerDecorator implements ComputerInterface {
	private ComputerInterface computer;

	public ComputerDecorator(ComputerInterface computer) {
		this.computer = computer;
	}

	@Override
	public double getPrice() {
		return this.computer.getPrice();
	}
}
