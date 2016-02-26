package br.usc.poo.exerc.ex02;

import java.io.Serializable;

public class Document implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private transient String token;

	public Document(int id, String name, String token) {
		super();
		this.id = id;
		this.name = name;
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getToken() {
		return token;
	}
}
