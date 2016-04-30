package br.usc.designpatterns.atividade03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Colaborador extends ColaboradorAbstract {
	private List<ColaboradorAbstract> subordinados = new ArrayList<>();

	public Colaborador(String matricula, String nome, CargoEnum cargo, String time) {
		super(matricula, nome, cargo, time);
	}

	public void add(List<ColaboradorAbstract> colaboradores) {
		this.subordinados.addAll(colaboradores);
	}
	
	public void add(ColaboradorAbstract colaborador) {
		this.subordinados.add(colaborador);
	}

	public void remove(ColaboradorAbstract colaborador) {
		this.subordinados.remove(colaborador);
	}

	public List<ColaboradorAbstract> getSubordinados() {
		return Collections.unmodifiableList(this.subordinados);
	}
}
