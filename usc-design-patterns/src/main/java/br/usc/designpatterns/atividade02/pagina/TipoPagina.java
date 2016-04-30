package br.usc.designpatterns.atividade02.pagina;

public abstract class TipoPagina {
	private String titulo;
	private String texto;

	public TipoPagina(String titulo, String texto) {
		super();
		this.titulo = titulo;
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTexto() {
		return texto;
	}

}
