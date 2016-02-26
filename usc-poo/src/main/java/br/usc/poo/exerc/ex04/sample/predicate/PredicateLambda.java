package br.usc.poo.exerc.ex04.sample.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateLambda {
	public static void main(String[] args) {
		/**
		 * Lista de Funcionários
		 */
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(new Funcionario(1, "Robson", 26, "M"));
		funcionarios.add(new Funcionario(2, "Fátima", 56, "F"));
		funcionarios.add(new Funcionario(3, "David", 26, "M"));
		funcionarios.add(new Funcionario(4, "Rodrigo", 28, "M"));
		funcionarios.add(new Funcionario(5, "Paula", 39, "F"));

		/**
		 * Predicate - Filtrar Adultos do Sexo Masculino
		 */
		Predicate<Funcionario> isAdultoMasculino = f -> f.getIdade() > 21 && f.getSexo().equalsIgnoreCase("M");
		
		/**
		 * Query
		 */
		System.out.println("Adultos do Sexo Masculino: ");
		funcionarios.stream().filter(isAdultoMasculino).forEach(f -> System.out.println(f.getNome()));

		/**
		 * Predicate - Filtrar Adultos do Sexo Feminino
		 */
		Predicate<Funcionario> isAdultoFeminino = f -> f.getIdade() > 21 && f.getSexo().equalsIgnoreCase("F");

		/**
		 * Query
		 */
		System.out.println("Adultos do Sexo Feminino: ");
		funcionarios.stream().filter(isAdultoFeminino).forEach(f -> System.out.println(f.getNome()));
	}
}
