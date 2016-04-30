package br.usc.designpatterns.atividade02.pagina;

import br.usc.designpatterns.atividade02.PaginaInterface;

public class Formacao extends TipoPagina implements PaginaInterface {
	public Formacao(String titulo, String texto) {
		super(titulo, texto);
	}
}