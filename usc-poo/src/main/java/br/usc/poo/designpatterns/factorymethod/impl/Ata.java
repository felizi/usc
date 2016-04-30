package br.usc.poo.designpatterns.factorymethod.impl;

import br.usc.poo.designpatterns.factorymethod.DocumentInterface;

/**
 * The Class Ata.
 */
public class Ata implements DocumentInterface {

	/* (non-Javadoc)
	 * @see br.usc.designpatterns.factorymethod.DocumentInterface#read()
	 */
	public String read() {
		return "Ata";
	}

	/* (non-Javadoc)
	 * @see br.usc.designpatterns.factorymethod.DocumentInterface#write(java.lang.String)
	 */
	public void write(String txt) {
		System.out.println("Ata: " + txt);
	}

}
