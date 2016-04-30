package br.usc.designpatterns.atividade04;

public class OfficeLicenseComputerDecorator implements ComputerInterface {
	private ComputerInterface computer;

	public OfficeLicenseComputerDecorator(ComputerInterface computer) {
		this.computer = computer;
	}

	@Override
	public double getPrice() {
		return this.computer.getPrice() + 350;
	}
}
