package br.usc.designpatterns.adapter.impl;

import br.usc.designpatterns.adapter.ConnectorInterface;

/**
 * Connector implements of three pins
 */
public class ThreePinsConnector implements ConnectorInterface {
	
	/**
	 * Three pins return
	 */
	@Override
	public int connect() {
		return 3;
	}
}
