package br.usc.designpatterns.factory.impl;

import br.usc.designpatterns.factory.SenderInterface;

/**
 * Mecanismo - Envio por E-mail.
 */
public class EmailSender implements SenderInterface {

	/* (non-Javadoc)
	 * @see br.usc.designpatterns.factory.SenderInterface#send(java.lang.String)
	 */
	public void send(String msg) {
		System.out.println("Send by E-mail");
		System.out.println(msg);
	}
}
