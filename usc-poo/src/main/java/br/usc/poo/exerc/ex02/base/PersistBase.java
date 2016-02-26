package br.usc.poo.exerc.ex02.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistBase<T> {
	private String filename;

	public PersistBase(String filename) {
		this.filename = filename;
	}

	public void persist(T object) throws FileNotFoundException, IOException {
		ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(this.filename));

		writer.writeObject(object);

		writer.close();
	}

	public T read() throws FileNotFoundException, IOException, ClassNotFoundException {

		ObjectInputStream reader = new ObjectInputStream(new FileInputStream(this.filename));

		T obj = (T) reader.readObject();

		reader.close();

		return obj;
	}

}
