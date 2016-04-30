package br.usc.designpatterns.atividade04;

import br.usc.designpatterns.atividade04.components.OperatingSystem;
import br.usc.designpatterns.atividade04.components.ProcessMemory;
import br.usc.designpatterns.atividade04.components.Processor;
import br.usc.designpatterns.atividade04.components.StoreMemory;

public class BasicComputerImpl implements ComputerInterface {
	private OperatingSystem os;
	private StoreMemory disk;
	private ProcessMemory memory;
	private Processor processor;

	public BasicComputerImpl(OperatingSystem os, StoreMemory disk, ProcessMemory memory, Processor processor) {
		super();
		this.os = os;
		this.disk = disk;
		this.memory = memory;
		this.processor = processor;
	}

	public OperatingSystem getOs() {
		return os;
	}

	public StoreMemory getDisk() {
		return disk;
	}

	public ProcessMemory getMemory() {
		return memory;
	}

	public Processor getProcessor() {
		return processor;
	}

	@Override
	public double getPrice() {
		return os.getPrice() + disk.getPrice() + memory.getPrice() + processor.getPrice();
	}
}
