package br.usc.log.services;

import br.usc.log.services.impl.LogServiceImpl;

public class LogFactory {

	private static LogFactory logFactory;
	private LogServiceImpl logServiceImpl;

	public static LogFactory getInstance() {
		if (logFactory == null) {
			logFactory = new LogFactory();
		}
		return logFactory;
	}

	public LogServiceImpl getLogServiceImpl() {
		if(logServiceImpl == null){ 
			logServiceImpl= new LogServiceImpl();
		}
		return logServiceImpl;
	}
}
