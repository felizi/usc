package br.usc.log.services.impl;

import br.usc.log.enums.LogLevelEnum;
import br.usc.log.exception.InvalidLogException;
import br.usc.log.services.LogServiceInterface;

public class LogServiceImpl implements LogServiceInterface {

	public void logger(LogLevelEnum logLevel, String message) throws InvalidLogException {
		if (logLevel == null || message == null) {
			throw new InvalidLogException();
		}
		
		System.out.println(logLevel + ": " + message);
	}

}
