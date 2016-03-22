package br.usc.poo.sistema.repository.generator;

/**
 * Classe responsável por realizar a geração de identificador único.
 */
public class IdGenerator {
	private int id = 0;

	/**
	 * Instancia um novo gerador
	 */
	private IdGenerator() {
		super();
	}

	/**
	 * Instancia um novo gerador
	 *
	 * @return gerador
	 */
	public static IdGenerator of() {
		return new IdGenerator();
	}

	/**
	 * Gerar um novo identificador
	 *
	 * @return o identificador
	 */
	public int generate() {
		return ++id;
	}
}
