package br.usc.poo.exerc.ex04.sample;

import java.util.Arrays;
import java.util.List;

public class ForEachSample {
	public static void main(String[] args) {
		// Coleção de Nomes
		List<String> collection = Arrays.asList("Robson", "Fernando", "Bruno", "Rodrigo", "Rafael", "Robson");
		
		/**
		 * Sem Expressão Lambda
		 */
		for (String nome : collection) {
			System.out.println(nome);
		}

		/**
		 * Com Expressão Lambda
		 */
		collection.stream().forEach(s -> System.out.println(s));
	}
}
