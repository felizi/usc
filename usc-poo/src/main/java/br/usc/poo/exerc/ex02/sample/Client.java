package br.usc.poo.exerc.ex02.sample;

import java.io.Serializable;

public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private transient String name;

	public Client(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: ");
		sb.append(this.id);
		sb.append("Name: ");
		sb.append(this.name);
		return sb.toString();
	}
}
