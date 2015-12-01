package br.usc.log.services;

import br.usc.log.enums.LogLevelEnum;
import br.usc.log.exception.InvalidLogException;

public interface LogServiceInterface {

	public void logger(LogLevelEnum logLevel, String message) throws InvalidLogException;

}
