package br.usc.designpatterns.atividade02.pagina;

import br.usc.designpatterns.atividade02.PaginaInterface;

public class Sumario extends TipoPagina implements PaginaInterface {
	public Sumario(String titulo, String texto) {
		super(titulo, texto);
	}
}
