package br.usc.designpatterns.atividade03;

public abstract class ColaboradorAbstract {
	private String matricula = "";
	private String nome = "";
	private CargoEnum cargo = null;
	private String time = "";

	public ColaboradorAbstract(String matricula, String nome, CargoEnum cargo, String time) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.cargo = cargo;
		this.time = time;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public CargoEnum getCargo() {
		return cargo;
	}

	public String getTime() {
		return time;
	}
}
