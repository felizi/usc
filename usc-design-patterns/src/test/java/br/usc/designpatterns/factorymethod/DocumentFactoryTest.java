package br.usc.designpatterns.factorymethod;

import org.junit.Assert;
import org.junit.Test;

import br.usc.designpatterns.factorymethod.enumerator.DocumentEnum;
import br.usc.designpatterns.factorymethod.impl.Ata;
import br.usc.designpatterns.factorymethod.impl.Certidao;
import br.usc.designpatterns.factorymethod.impl.Oficio;

public class DocumentFactoryTest {
	@Test
	public void deveRetornarUmDocumentoAta() {
		DocumentInterface ata = DocumentFactory.create(DocumentEnum.ATA);
		Assert.assertTrue(ata instanceof Ata);
	}

	@Test
	public void deveRetornarUmDocumentoOficio() {
		DocumentInterface ata = DocumentFactory.create(DocumentEnum.OFICIO);
		Assert.assertTrue(ata instanceof Oficio);
	}

	@Test
	public void deveRetornarUmDocumentoCertidao() {
		DocumentInterface ata = DocumentFactory.create(DocumentEnum.CERTIDAO);
		Assert.assertTrue(ata instanceof Certidao);
	}

	@Test
	public void deveLerUmDocumentoAta() {
		DocumentInterface ata = DocumentFactory.create(DocumentEnum.ATA);
		String read = ata.read();
		Assert.assertEquals("Ata", read);
	}

	@Test
	public void deveLerUmDocumentoOficio() {
		DocumentInterface ata = DocumentFactory.create(DocumentEnum.OFICIO);
		String read = ata.read();
		Assert.assertEquals("Ofício", read);
	}

	@Test
	public void deveLerUmDocumentoCertidao() {
		DocumentInterface ata = DocumentFactory.create(DocumentEnum.CERTIDAO);
		String read = ata.read();
		Assert.assertEquals("Certidão", read);
	}

	@Test
	public void deveRetornarNullSeInvalido() {
		DocumentInterface invalido = DocumentFactory.create(null);
		Assert.assertNull(invalido);
	}
}
