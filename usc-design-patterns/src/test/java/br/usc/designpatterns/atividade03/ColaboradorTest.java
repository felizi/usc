package br.usc.designpatterns.atividade03;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ColaboradorTest {

	private Colaborador gerente;
	private Colaborador supervisor;
	private Colaborador liderTecnico1;
	private Colaborador liderTecnico2;

	@Before
	public void setup() {
		List<ColaboradorAbstract> desenvolvedores1 = new ArrayList<ColaboradorAbstract>();
		for (int i = 1; i <= 10; i++) {
			desenvolvedores1.add(new Desenvolvedor("DEV1." + i, "Desenvolvedor 1." + i, "time01"));
		}

		liderTecnico1 = new Colaborador("LID1", "Líder 1", CargoEnum.LIDER_TECNICO, "time01");
		liderTecnico1.add(desenvolvedores1);

		List<ColaboradorAbstract> desenvolvedores2 = new ArrayList<ColaboradorAbstract>();
		for (int i = 1; i <= 5; i++) {
			desenvolvedores2.add(new Desenvolvedor("DEV2." + i, "Desenvolvedor 2." + i, "time01"));
		}

		liderTecnico2 = new Colaborador("LID2", "Líder 2", CargoEnum.LIDER_TECNICO, "time01");
		liderTecnico2.add(desenvolvedores2);

		supervisor = new Colaborador("SUP1", "Supervisor 1", CargoEnum.SUPERVISOR, "time01");
		supervisor.add(liderTecnico1);
		supervisor.add(liderTecnico2);

		gerente = new Colaborador("GER1", "Gerente 1", CargoEnum.GERENTE, "time01");
		gerente.add(supervisor);
	}

	@Test
	public void deveRetornarSubordinadosDoGerente() {
		Assert.assertEquals(1, gerente.getSubordinados().size());
	}

	@Test
	public void deveRetornarSubordinadosDoSupervisor() {
		Assert.assertEquals(2, supervisor.getSubordinados().size());
	}

	@Test
	public void deveRetornarSubordinadosDoLiderTecnico1() {
		Assert.assertEquals(10, liderTecnico1.getSubordinados().size());
	}

	@Test
	public void deveRetornarSubordinadosDoLiderTecnico2() {
		Assert.assertEquals(5, liderTecnico2.getSubordinados().size());
	}
}
