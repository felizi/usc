package br.usc.designpatterns.factory;

import org.junit.Assert;
import org.junit.Test;

import br.usc.designpatterns.factory.enumerator.SenderEnum;
import br.usc.designpatterns.factory.impl.ApplicationSender;
import br.usc.designpatterns.factory.impl.EmailSender;
import br.usc.designpatterns.factory.impl.SMSSender;

public class SenderFactoryTest {
	@Test
	public void deveRetornarApplication() {
		SenderInterface app = SenderFactory.of(SenderEnum.APP);
		Assert.assertTrue(app instanceof ApplicationSender);
	}

	@Test
	public void deveRetornarSMS() {
		SenderInterface sms = SenderFactory.of(SenderEnum.SMS);
		Assert.assertTrue(sms instanceof SMSSender);
	}

	@Test
	public void deveRetornarEmail() {
		SenderInterface email = SenderFactory.of(SenderEnum.EMAIL);
		Assert.assertTrue(email instanceof EmailSender);
	}

	@Test
	public void deveRetornarNullSeInvalido() {
		SenderInterface app = SenderFactory.of(null);
		Assert.assertNull(app);
	}
}
