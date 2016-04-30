package br.usc.designpatterns.atividade02.documento;

import java.util.Arrays;
import java.util.List;

import br.usc.designpatterns.atividade02.PaginaInterface;
import br.usc.designpatterns.atividade02.pagina.ExperienciaProfissional;
import br.usc.designpatterns.atividade02.pagina.Formacao;
import br.usc.designpatterns.atividade02.pagina.Habilidades;

public class CurriculoFactoryImpl implements DocumentoFactoryInterface {

	@Override
	public List<PaginaInterface> criarPagina() {
		return Arrays.asList(new Habilidades("",""), new Formacao("",""), new ExperienciaProfissional("",""));
	}

}
