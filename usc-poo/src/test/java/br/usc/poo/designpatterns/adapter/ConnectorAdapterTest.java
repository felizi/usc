package br.usc.poo.designpatterns.adapter;

import org.junit.Assert;
import org.junit.Test;

import br.usc.poo.designpatterns.adapter.ConnectorAdapter;
import br.usc.poo.designpatterns.adapter.ConnectorInterface;
import br.usc.poo.designpatterns.adapter.impl.ThreePinsConnector;
import br.usc.poo.designpatterns.adapter.impl.TwoPinsConnector;

public class ConnectorAdapterTest {
	@Test
	public void deveRetornarConectorDeDoisPinos() {
		ConnectorInterface twoPins = new TwoPinsConnector();
		ConnectorAdapter connectorAdapter = new ConnectorAdapter(twoPins);
		int pins = connectorAdapter.connect();
		Assert.assertEquals(2, pins);
	}

	@Test
	public void deveRetornarConectorDeTresPinos() {
		ConnectorInterface twoPins = new ThreePinsConnector();
		ConnectorAdapter connectorAdapter = new ConnectorAdapter(twoPins);
		int pins = connectorAdapter.connect();
		Assert.assertEquals(3, pins);
	}

	@Test(expected = NullPointerException.class)
	public void deveRetornarException() {
		ConnectorAdapter connectorAdapter = new ConnectorAdapter(null);
		connectorAdapter.connect();
	}
}
