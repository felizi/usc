package br.usc.designpatterns.atividade02.documento;

import java.util.Arrays;
import java.util.List;

import br.usc.designpatterns.atividade02.PaginaInterface;
import br.usc.designpatterns.atividade02.pagina.Bibliografia;
import br.usc.designpatterns.atividade02.pagina.Conclusao;
import br.usc.designpatterns.atividade02.pagina.Resultado;
import br.usc.designpatterns.atividade02.pagina.Sumario;

public class RelatorioFactoryImpl implements DocumentoFactoryInterface {

	@Override
	public List<PaginaInterface> criarPagina() {
		return Arrays.asList(new Resultado(null, null), new Conclusao(null, null), new Sumario(null, null), new Bibliografia(null, null));
	}

}
