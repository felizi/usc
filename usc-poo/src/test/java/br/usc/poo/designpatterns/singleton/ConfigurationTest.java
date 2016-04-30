package br.usc.poo.designpatterns.singleton;

import org.junit.Assert;
import org.junit.Test;

import br.usc.poo.designpatterns.singleton.Configuration;

public class ConfigurationTest {
	@Test
	public void deveRetornarNulo() {
		String property = Configuration.getInstance().getProperty("");
		Assert.assertNull(property);
	}

	@Test
	public void deveRetornarPropertyFonteTimeZone() {
		String property = Configuration.getInstance().getProperty("time-zone");
		Assert.assertEquals("América/São Paulo", property);
	}

	@Test
	public void deveRetornarPropertyFonteCurrencyCode() {
		String property = Configuration.getInstance().getProperty("currency-code");
		Assert.assertEquals("BRL", property);
	}

	@Test
	public void deveRetornarPropertyArquivoYear() {
		String property = Configuration.getInstance().getProperty("year");
		Assert.assertEquals("2016", property);
	}

	@Test
	public void deveRetornarPropertyArquivoCollege() {
		String property = Configuration.getInstance().getProperty("college");
		Assert.assertEquals("usc", property);
	}

	@Test
	public void deveRetornarPropertyArquivoCourse() {
		String property = Configuration.getInstance().getProperty("course");
		Assert.assertEquals("software engineering", property);
	}

	@Test
	public void deveRetornarPropertyArquivoEmpty() {
		String property = Configuration.getInstance().getProperty("empty");
		Assert.assertEquals("", property);
	}
}
