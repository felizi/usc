package br.usc.poo.exerc.ex04.sample.predicate;

public class Funcionario {
	private Integer codigo;
	private String nome;
	private Integer idade;
	private String sexo;

	/**
	 * Construtor sobrecarga
	 */
	public Funcionario(Integer codigo, String nome, Integer idade, String sexo) {
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
