package br.usc.poo.designpatterns.factory.impl;

import br.usc.poo.designpatterns.factory.SenderInterface;

/**
 * Mecanismo - Envio por Aplicação.
 */
public class ApplicationSender implements SenderInterface {

	/* (non-Javadoc)
	 * @see br.usc.designpatterns.factory.SenderInterface#send(java.lang.String)
	 */
	public void send(String msg) {
		System.out.println("Send by Application");
		System.out.println(msg);
	}
}
