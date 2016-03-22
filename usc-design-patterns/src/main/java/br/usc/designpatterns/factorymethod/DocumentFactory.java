package br.usc.designpatterns.factorymethod;

import br.usc.designpatterns.factorymethod.enumerator.DocumentEnum;
import br.usc.designpatterns.factorymethod.impl.Ata;
import br.usc.designpatterns.factorymethod.impl.Certidao;
import br.usc.designpatterns.factorymethod.impl.Oficio;

/**
 * Fábrica para criação de objetos de Document
 */
public class DocumentFactory {

	/**
	 * Cria um novo documento através do tipo (DocumentEnum)
	 *
	 * @param documentEnum tipo do documento
	 * @return um tipo concreto de documento
	 */
	public static DocumentInterface create(DocumentEnum documentEnum) {
		if (documentEnum == null) {
			return null;
		}
		switch (documentEnum) {
		case ATA:
			return new Ata();
		case CERTIDAO:
			return new Certidao();
		case OFICIO:
			return new Oficio();
		default:
			return null;
		}
	}
}
