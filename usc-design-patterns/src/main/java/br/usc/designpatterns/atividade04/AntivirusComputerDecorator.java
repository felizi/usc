package br.usc.designpatterns.atividade04;

public class AntivirusComputerDecorator implements ComputerInterface {
	private ComputerInterface computer;

	public AntivirusComputerDecorator(ComputerInterface computer) {
		this.computer = computer;
	}

	@Override
	public double getPrice() {
		return this.computer.getPrice() + 500;
	}
}
