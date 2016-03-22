package br.usc.designpatterns.factory;

import br.usc.designpatterns.factory.enumerator.SenderEnum;
import br.usc.designpatterns.factory.impl.ApplicationSender;
import br.usc.designpatterns.factory.impl.EmailSender;
import br.usc.designpatterns.factory.impl.SMSSender;

/**
 * Uma fábrica que cria envios (app, email, sms)
 */
public class SenderFactory {

	/**
	 * Cria um novo Sender
	 *
	 * @param senderEnum the sender enum
	 * @return the sender interface
	 */
	public static SenderInterface of(SenderEnum senderEnum) {
		if (senderEnum == null) {
			return null;
		}
		switch (senderEnum) {
		case APP:
			return new ApplicationSender();
		case EMAIL:
			return new EmailSender();
		case SMS:
			return new SMSSender();
		default:
			return null;
		}
	}
}
