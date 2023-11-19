package Cine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Principal {
	private static Scanner sc;
	private Cinema cineUcs;

	public Principal() {
		cineUcs = new Cinema();
		resgatarDados();
	}

	public static void main(String[] args) {
		Principal pr = new Principal();
		pr.menu();
	}

	public void menu() {
		sc = new Scanner(System.in);
		int opcao = 0;
		
		System.out.println(cineUcs);

		do {
			System.out.println("-----------------------");
			System.out.println("Bem Vindo ao Cinema POO");
			System.out.println("1 - Comprar ingresso");
			System.out.println("2 - Listar filmes do catálogo");
			System.out.println("3 - Menu Cadastrar");
			System.out.println("4 - Exit");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				comprarIngresso();
			case 2:
				filmesCatalogo();
				menu();
			case 3:
				menuCadastrar();
			case 4:
				System.out.println("-----------------------");
				System.out.println("Sistema sendo finalizado e gravando dados");
				gravarDados();
				System.exit(4);
			}
		} while (opcao != 0);
		sc.close();
	}

	public void comprarIngresso() {

	}

	public void filmesCatalogo() {
		cineUcs.getFilmes();
	}

	public void menuCadastrar() {

		int opcao = 0;
		do {
			System.out.println("-----------------------");
			System.out.println("----MENU CADASTRAR----");
			System.out.println("1 - Dados do Cinema");
			System.out.println("2 - Listar Salas do Cinema");
			System.out.println("3 - Dados dos Filmes");
			System.out.println("4 - Adicionar Atores ao banco de dados");
			System.out.println("5 - Adicionar diretores ao banco de dados");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				dadosCinema();
			case 2:
				listarSalasCinema();
			case 3:
				dadosFilmesCinema();
//			case 4:
//				alterarDadosFilme();
//			case 5:
//				addAtorBanco();
//			case 6:
//				addDiretorBanco();
			}

		} while (opcao != 0);
	}

	public void dadosCinema() {
		String res;
		String s = "s";
		String opcao = "a";
		System.out.println("-----------------------");
		System.out.println(cineUcs);
		System.out.println("Alterar nome do Cinema? [S] sim / [N] não");
		opcao = sc.nextLine();
		if (opcao.equalsIgnoreCase(s)) {
			System.out.println("Altere o nome do cinema:");
			res = sc.nextLine();
			cineUcs.setNome(res);
			System.out.println(gravarDados());
		}
		System.out.println("Alterar endereço do Cinema? [S] sim / [N] não");
		opcao = sc.nextLine();
		if (opcao.equalsIgnoreCase(s)) {
			System.out.println("Alter o endereço do cinema:");
			res = sc.nextLine();
			cineUcs.setEndereco(res);
			System.out.println(gravarDados());
		}
		System.out.println("Retornando para o menu principal");
		menu();
	}

	public void listarSalasCinema() {
		String res;
		String s = "s";
		System.out.println("-----------------------");
		System.out.println("- Salas do Cinema - ");
		System.out.println(cineUcs.getSalas());
		do {
			System.out.println("Adicionar sala ao Cinema? [S] sim / [N] não");
			res = sc.nextLine().toLowerCase();
			if (res.equalsIgnoreCase(s)) {
				cineUcs.addSala();
				System.out.println(gravarDados());
				System.out.println("Adicionar outra sala ao Cinema? [S] sim / [N] não");
				res = sc.nextLine().toLowerCase();
			}
		} while (res == "s");
	}

	public void dadosFilmesCinema() {
		String res;
		int opcao;

		System.out.println("-----------------------");
		filmesCatalogo();
		System.out.println("1 - Adicionar filme ao Catálago");
		System.out.println("2 - Alterar dados do filme");
		opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			System.out.println("Adicionando filem ao catálago");
			System.out.println("Qual o nome do filme?");
			res = sc.nextLine();
			cineUcs.addFilme(res);

		}

	}

	public String resgatarDados() {
		try {
			FileInputStream file = new FileInputStream("POOcineT2.dat");
			ObjectInputStream oi = new ObjectInputStream(file);
			Object o = oi.readObject();
			cineUcs = (Cinema) o;
			oi.close();
			file.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			gravarDados();
			resgatarDados();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "Dados resgatados com sucesso";
	}

	public String gravarDados() {
		try {
			FileOutputStream file = new FileOutputStream("POOcineT2.dat");
			ObjectOutputStream ou = new ObjectOutputStream(file);
			ou.writeObject(cineUcs);
			ou.close();
			file.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return "Dados não foram gravados";
		}
		return "Dados gravados com sucesso";
	}

}