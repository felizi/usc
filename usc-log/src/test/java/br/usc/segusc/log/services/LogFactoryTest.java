package br.usc.segusc.log.services;

import static org.junit.Assert.assertNotNull;

import br.usc.log.enums.LogLevelEnum;
import br.usc.log.exception.InvalidLogException;
import br.usc.log.services.LogFactory;
import br.usc.log.services.impl.LogServiceImpl;

public class LogFactoryTest {

	@org.junit.Test
	public void testLogFactory() {
		LogFactory instance = LogFactory.getInstance();
		assertNotNull(instance);
	}

	@org.junit.Test
	public void testLogFactoryGetInstanceOfLogServiceImpl() {
		LogServiceImpl logServiceImpl = LogFactory.getInstance().getLogServiceImpl();
		assertNotNull(logServiceImpl);
	}

	@org.junit.Test
	public void testLoggerInfoOfLogServiceImpl() throws InvalidLogException {
		LogServiceImpl logServiceImpl = LogFactory.getInstance().getLogServiceImpl();
		logServiceImpl.logger(LogLevelEnum.INFO, "Info!");
	}

	@org.junit.Test
	public void testLoggerWarningOfLogServiceImpl() throws InvalidLogException {
		LogServiceImpl logServiceImpl = LogFactory.getInstance().getLogServiceImpl();
		logServiceImpl.logger(LogLevelEnum.WARNING, "Warning!");
	}

	@org.junit.Test
	public void testLoggerErrorOfLogServiceImpl() throws InvalidLogException {
		LogServiceImpl logServiceImpl = LogFactory.getInstance().getLogServiceImpl();
		logServiceImpl.logger(LogLevelEnum.ERROR, "Error!");
	}
	
	@org.junit.Test(expected = InvalidLogException.class)
	public void testLoggerLevelNullOfLogServiceImpl() throws InvalidLogException {
		LogServiceImpl logServiceImpl = LogFactory.getInstance().getLogServiceImpl();
		logServiceImpl.logger(null, "Teste null!");
	}
	
	@org.junit.Test(expected = InvalidLogException.class)
	public void testLoggerMessageNullOfLogServiceImpl() throws InvalidLogException {
		LogServiceImpl logServiceImpl = LogFactory.getInstance().getLogServiceImpl();
		logServiceImpl.logger(LogLevelEnum.ERROR, null);
	}
	
	@org.junit.Test(expected = InvalidLogException.class)
	public void testLoggerLevelAndMessageNullOfLogServiceImpl() throws InvalidLogException {
		LogServiceImpl logServiceImpl = LogFactory.getInstance().getLogServiceImpl();
		logServiceImpl.logger(null, null);
	}
}
