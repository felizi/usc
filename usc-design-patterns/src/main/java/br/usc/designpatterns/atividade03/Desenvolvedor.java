package br.usc.designpatterns.atividade03;

public class Desenvolvedor extends ColaboradorAbstract {
	public Desenvolvedor(String matricula, String nome, String time) {
		super(matricula, nome, CargoEnum.DESENVOLVEDOR, time);
	}
}
