package br.usc.designpatterns.atividade02.pagina;

import br.usc.designpatterns.atividade02.PaginaInterface;

public class Conclusao extends TipoPagina implements PaginaInterface {
	public Conclusao(String titulo, String texto) {
		super(titulo, texto);
	}
}