package main.util.io.implementation;

import main.util.io.Entrada;

import java.util.Scanner;

public class Teclado implements Entrada {
	public Scanner teclado = new Scanner(System.in);

	public Integer leInteiro() {
		String numeroLido = teclado.nextLine();
		return Integer.parseInt(numeroLido);
	}
	
	public Integer leInteiro(String prompt) {
		System.out.print(prompt);
		return leInteiro();
	}
	
	public String leString() {
		return teclado.nextLine();
	}
	
	public String leString(String prompt) {
		System.out.print(prompt);
		return leString();
	}

	public Double leDouble() {
		String numeroLido = teclado.nextLine();
		return Double.parseDouble(numeroLido.replace(",", "."));
	}
	
	public Double leDouble(String prompt) {
		System.out.print(prompt);
		return leDouble();
	}
}
