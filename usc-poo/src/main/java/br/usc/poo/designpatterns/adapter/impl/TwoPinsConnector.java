package br.usc.poo.designpatterns.adapter.impl;

import br.usc.poo.designpatterns.adapter.ConnectorInterface;

/**
 * Connector implements of two pins
 */
public class TwoPinsConnector implements ConnectorInterface {

	/**
	 * Two pins return
	 */
	@Override
	public int connect() {
		return 2;
	}
}
