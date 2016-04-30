package br.usc.designpatterns.atividade04.components;

public class OperatingSystem {
	private String name;
	private double price;

	public OperatingSystem(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

}
