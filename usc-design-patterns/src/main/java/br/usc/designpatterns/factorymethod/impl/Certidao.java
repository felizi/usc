package br.usc.designpatterns.factorymethod.impl;

import br.usc.designpatterns.factorymethod.DocumentInterface;

/**
 * The Class Certidao.
 */
public class Certidao implements DocumentInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.usc.designpatterns.factorymethod.DocumentInterface#read()
	 */
	public String read() {
		return "Certidão";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.usc.designpatterns.factorymethod.DocumentInterface#write(java.lang.
	 * String)
	 */
	public void write(String txt) {
		System.out.println("Certidão: " + txt);
	}

}
