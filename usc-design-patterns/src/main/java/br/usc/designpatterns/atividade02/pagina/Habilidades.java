package br.usc.designpatterns.atividade02.pagina;

import br.usc.designpatterns.atividade02.PaginaInterface;

public class Habilidades extends TipoPagina implements PaginaInterface {
	public Habilidades(String titulo, String texto) {
		super(titulo, texto);
	}
}