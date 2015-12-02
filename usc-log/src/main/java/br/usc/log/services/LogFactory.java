package br.usc.log.services;

import br.usc.log.services.impl.LogServiceImpl;

public class LogFactory {

	private static LogFactory logFactory;
	private LogServiceInterface logService;

	public static LogFactory getInstance() {
		if (logFactory == null) {
			logFactory = new LogFactory();
		}
		return logFactory;
	}

	public LogServiceInterface getLogServiceImpl() {
		if(logService == null){ 
			logService= new LogServiceImpl();
		}
		return logService;
	}
}
