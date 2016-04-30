package br.usc.designpatterns.atividade02.pagina;

import br.usc.designpatterns.atividade02.PaginaInterface;

public class Bibliografia extends TipoPagina implements PaginaInterface {
	public Bibliografia(String titulo, String texto) {
		super(titulo, texto);
	}
}