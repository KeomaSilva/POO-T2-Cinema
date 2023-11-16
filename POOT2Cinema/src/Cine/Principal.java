package Cine;

import java.io.Serializable;

public class Principal implements Serializable{
	private Cinema ucs;

	public Principal() {
		Cinema ucs = new Cinema();
	}

	public static void main(String[] args) {
		Principal pr = new Principal();
		pr.menu();
	}
	
	public void menu() {
		System.out.println("-------------------------------");
		System.out.println("--- Bem Vindo ao Cinema POO ---");
		
	}

}
