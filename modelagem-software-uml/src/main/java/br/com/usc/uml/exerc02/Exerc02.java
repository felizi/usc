package br.com.usc.uml.exerc02;

public class Exerc02 {
	
	public static void main(String[] args) {
		Produto celular = new Produto("Celular", 2000, 10);
		Produto relogio = new Produto("Relógio", 300, 5);
		Produto carteira = new Produto("Carteira", 100, 50);
		Produto notebook = new Produto("Notebook", 3000, 6);
		
		Pedido pedido = new Pedido();
		pedido.adicionar(celular);
		pedido.adicionar(relogio);
		pedido.adicionar(carteira);
		pedido.adicionar(notebook);
		
		System.out.println("Total: " + pedido.calcularValor());
		
	}

}
