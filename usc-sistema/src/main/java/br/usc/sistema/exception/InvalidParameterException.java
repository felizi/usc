package br.usc.sistema.exception;

public class InvalidParameterException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidParameterException() {
		super();
	}

	public InvalidParameterException(String message) {
		super(message);
	}

}
