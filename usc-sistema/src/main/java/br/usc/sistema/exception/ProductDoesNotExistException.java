package br.usc.sistema.exception;

public class ProductDoesNotExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public ProductDoesNotExistException(String message) {
		super(message);
	}

}
