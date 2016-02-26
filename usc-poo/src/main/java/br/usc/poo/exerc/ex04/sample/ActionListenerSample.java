package br.usc.poo.exerc.ex04.sample;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionListenerSample {

	public static void main(String[] args) {
		JButton buttonOK = new JButton("OK");

		// Listener -> Sem Expressão Lambda

		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Click sem Lambda");
			}

		});

		// Listener -> Com Expressão Lambda
		buttonOK.addActionListener(e -> System.out.println("Click com Lambda"));

		// Janela básica em Java
		JFrame frame = new JFrame("Teste Lambda");
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(buttonOK, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
