package br.usc.log.enums;

public enum LogLevelEnum {
	INFO(1), WARNING(2), ERROR(3);
	
	public int value;

	private LogLevelEnum(int value) {
		this.value = value;
	}

}
