package br.usc.poo.exerc.ex02.sample;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.usc.poo.exerc.ex02.sample.Client;
import br.usc.poo.exerc.ex02.sample.PersistClient;

public class PersistClientTest {

	private final int ID = 10;
	private final String NAME = "Test Name :D";

	private String filename;
	private PersistClient persistClient;
	private Client client;

	@Before
	public void setup() {
		this.filename = "test.tst";
		this.persistClient = new PersistClient(filename);
		this.client = new Client(ID, NAME);
	}

	@Test
	public void testPersistCall() throws FileNotFoundException, IOException {
		this.persistClient.persist(this.client);
	}

	@Test
	public void testPersistRead() throws FileNotFoundException, IOException, ClassNotFoundException {
		Client client = this.persistClient.read();
		client.toString();
	}

	@Test
	public void testClientSetup() throws FileNotFoundException, IOException, ClassNotFoundException {
		org.junit.Assert.assertEquals(NAME, this.client.getName());
		org.junit.Assert.assertEquals(ID, this.client.getId());
	}

	@Test
	public void testPersistReadName() throws FileNotFoundException, IOException, ClassNotFoundException {
		Client client = this.persistClient.read();
		org.junit.Assert.assertNull(client.getName());
	}

	@Test
	public void testPersistReadNameNotEquals() throws FileNotFoundException, IOException, ClassNotFoundException {
		Client client = this.persistClient.read();
		org.junit.Assert.assertNotEquals(NAME, client.getName());
	}

	@Test
	public void testPersistReadId() throws FileNotFoundException, IOException, ClassNotFoundException {
		Client client = this.persistClient.read();
		org.junit.Assert.assertEquals(ID, client.getId());
	}

}
