package br.usc.designpatterns.atividade04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.usc.designpatterns.atividade04.components.OperatingSystem;
import br.usc.designpatterns.atividade04.components.ProcessMemory;
import br.usc.designpatterns.atividade04.components.Processor;
import br.usc.designpatterns.atividade04.components.StoreMemory;

public class ComputerTest {

	private BasicComputerImpl computer;

	@Before
	public void setup() {
		OperatingSystem os = new OperatingSystem("Windows 10", 500);
		ProcessMemory memory = new ProcessMemory(8192);
		StoreMemory disk = new StoreMemory(1024000);
		Processor processor = new Processor("Intel Core i7", 1000);

		this.computer = new BasicComputerImpl(os, disk, memory, processor);
	}

	@Test
	public void deveDecorarComputadorBasico() {
		Assert.assertEquals(2216.8, this.computer.getPrice(), 0);
	}

	@Test
	public void deveDecorarComputadorBasicoComAntivirus() {
		Assert.assertEquals(2716.8, new AntivirusComputerDecorator(this.computer).getPrice(), 0);
	}

	@Test
	public void deveDecorarComputadorBasicoComOfficeLicense() {
		Assert.assertEquals(2566.8, new OfficeLicenseComputerDecorator(this.computer).getPrice(), 0);
	}

	@Test
	public void deveDecorarComputadorBasicoComAntivirusAndOfficeLicense() {
		Assert.assertEquals(3066.8, new AntivirusComputerDecorator(new OfficeLicenseComputerDecorator(this.computer)).getPrice(), 0);
	}

}
