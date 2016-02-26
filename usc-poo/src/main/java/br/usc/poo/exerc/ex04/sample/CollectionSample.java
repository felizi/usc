package br.usc.poo.exerc.ex04.sample;

import java.util.Arrays;
import java.util.List;

public class CollectionSample {
	public static void main(String[] args) {
		List<String> collection = Arrays.asList("Robson", "Fernando", "Bruno", "Rodrigo", "Rafael", "Robson");

		// Expressão Lambda – Query Avançada
		collection.stream().filter(s -> s.startsWith("Ro")) // Filtro iniciam com "Ro”
				.distinct() // Remove duplicidade
				.map(s -> s.toUpperCase()) // Transformação
				.sorted() // Ordenação
				.forEach(s -> System.out.println(s)); // Iterator
	}
}
