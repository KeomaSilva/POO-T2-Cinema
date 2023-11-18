package Cine;

import java.util.Scanner;

public class Principal {
	private static Scanner sc;
	private Cinema ucs;

	public Principal() {
		Cinema ucs = new Cinema();
	}

	public static void main(String[] args) {
		Principal pr = new Principal();
		pr.menu();
	}

	public void menu() {
		Scanner sc = new Scanner(System.in);
		int opcao = 0;

		do {
			System.out.println("-----------------------");
			System.out.println("Bem Vindo ao Cinema POO");
			System.out.println("1 - Comprar ingresso");
			System.out.println("2 - Listar filmes do catálogo");
			System.out.println("3 - Menu Cadastrar");
			System.out.println("4 - Exit");
			opcao = sc.nextInt();
			sc.nextLine();
			sc.close();
			switch (opcao) {
			case 1:
				comprarIngresso();
			case 2:
				filmesCatalogo();
			case 3:
				menuCadastrar();
			case 4:
				System.exit(4);
			}
		} while (opcao != 0);
	}

	public void comprarIngresso() {

	}

	public void filmesCatalogo() {

	}

	public void menuCadastrar() {

		int opcao = 0;
		do {
			System.out.println("-----------------------");
			System.out.println("----MENU CADASTRAR----");
			System.out.println("1 - Dados do Cinema");
			System.out.println("2 - Listar Salas do Cinema");
			System.out.println("3 - Filme ao catálago");
			System.out.println("4 - Alterar dados de Filmes");
			System.out.println("5 - Adicionar Atores ao banco de dados");
			System.out.println("6 - Adicionar diretores ao banco de dados");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				dadosCinema();
			case 2:
				listarSalasCinema();
			case 3:
				addFilmeCatalogo();
			case 4:
				alterarDadosFilme();
			case 5:
				addAtorBanco();
			case 6:
				addDiretorBanco();	
				
		} while (opcao != 0);
	}
		public void dadosCinema() {
			
		}
		public void listarSalasCinema() {
			
		}
		public

}