package br.usc.designpatterns.atividade02.pagina;

import br.usc.designpatterns.atividade02.PaginaInterface;

public class ExperienciaProfissional extends TipoPagina implements PaginaInterface {
	public ExperienciaProfissional(String titulo, String texto) {
		super(titulo, texto);
	}
}