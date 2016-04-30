package br.usc.poo.designpatterns.singleton;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Classe de Configuração
 */
public class Configuration {
	// ---------------------------- Singleton ----------------------------
	private static Configuration instance;
	/**
	 * Dicionário de Propriedades
	 */
	private Map<String, String> properties;

	/**
	 * Construtor Privado
	 */
	private Configuration() {
		this.properties = new HashMap<>();
		this.properties.put("time-zone", "América/São Paulo");
		this.properties.put("currency-code", "BRL");
		this.properties.putAll(loadProperties("config.properties"));
	}

	private Map<String, String> loadProperties(String file) {
		try {
			Properties prop = new Properties();
			prop.load(getClass().getResourceAsStream(file));
			return new HashMap<String, String>((Map) prop);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Cria única instância do Objeto
	 * 
	 * @return
	 */
	public static Configuration getInstance() {
		/**
		 * Caso não exista instância, cria senão, apenas retorna objeto
		 */
		if (Configuration.instance == null) {
			Configuration.instance = new Configuration();
		}
		return Configuration.instance;

	}

	/**
	 * Obtém Propriedade
	 * 
	 * @param nomePropriedade
	 * @return
	 */
	public String getProperty(String property) {
		return this.properties.get(property);
	}
}
