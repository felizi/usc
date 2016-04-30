package br.usc.designpatterns.atividade02.pagina;

import br.usc.designpatterns.atividade02.PaginaInterface;

public class Resultado extends TipoPagina implements PaginaInterface {
	public Resultado(String titulo, String texto) {
		super(titulo, texto);
	}
}