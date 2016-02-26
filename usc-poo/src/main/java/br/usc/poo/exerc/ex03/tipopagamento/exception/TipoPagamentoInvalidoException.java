package br.usc.poo.exerc.ex03.tipopagamento.exception;

public class TipoPagamentoInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;

	public TipoPagamentoInvalidoException() {
		super();
	}

	public TipoPagamentoInvalidoException(Exception e) {
		super(e);
	}
}
