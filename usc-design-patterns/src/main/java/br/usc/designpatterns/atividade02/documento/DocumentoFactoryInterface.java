package br.usc.designpatterns.atividade02.documento;

import java.util.List;

import br.usc.designpatterns.atividade02.PaginaInterface;

public interface DocumentoFactoryInterface {
	public List<PaginaInterface> criarPagina();
}
