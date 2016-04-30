package br.usc.poo.designpatterns.factorymethod;

/**
 * Interface DocumentInterface.
 */
public interface DocumentInterface {

	/**
	 * Realiza a leitura de uma documento.
	 *
	 * @return the string
	 */
	public String read();

	/**
	 * Escreve em um documento.
	 *
	 * @param txt the txt
	 */
	public void write(String txt);
}
