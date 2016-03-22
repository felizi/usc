package br.usc.designpatterns.adapter;

/**
 * Connector Adapter
 */
public class ConnectorAdapter implements ConnectorInterface {

	/**
	 * Connector Interface
	 */
	private ConnectorInterface connector;

	/**
	 * Constructor with parameter
	 * 
	 * @param connector
	 */
	public ConnectorAdapter(ConnectorInterface connector) {
		this.connector = connector;
	}

	/**
	 * Connect override
	 */
	@Override
	public int connect() {
		return this.connector.connect();
	}
}
