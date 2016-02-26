package br.usc.poo.exerc.ex02;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class PersistDocumentTest {

	private final int ID = 99;
	private final String NAME = "Nome do Documento";
	private final String TOKEN = "asd9asda6d87asd68a7sd6asd76asda";
	private final String FILENAME = "document.tst";

	private PersistDocument persistDocument;
	private Document document;

	@Before
	public void setup() {
		this.persistDocument = new PersistDocument(FILENAME);
		this.document = new Document(ID, NAME, TOKEN);
	}

	@Test
	public void testPersistCall() throws FileNotFoundException, IOException {
		this.persistDocument.persist(this.document);
	}

	@Test
	public void testPersistRead() throws FileNotFoundException, IOException, ClassNotFoundException {
		Document document = this.persistDocument.read();
		document.toString();
	}

	@Test
	public void testDocumentSetup() throws FileNotFoundException, IOException, ClassNotFoundException {
		org.junit.Assert.assertEquals(NAME, this.document.getName());
		org.junit.Assert.assertEquals(ID, this.document.getId());
	}

	@Test
	public void testPersistReadToken() throws FileNotFoundException, IOException, ClassNotFoundException {
		Document document = this.persistDocument.read();
		org.junit.Assert.assertNull(document.getToken());
	}

	@Test
	public void testPersistReadTokenNotEquals() throws FileNotFoundException, IOException, ClassNotFoundException {
		Document document = this.persistDocument.read();
		org.junit.Assert.assertNotEquals(TOKEN, document.getToken());
	}

	@Test
	public void testPersistReadId() throws FileNotFoundException, IOException, ClassNotFoundException {
		Document document = this.persistDocument.read();
		org.junit.Assert.assertEquals(ID, document.getId());
	}

}
