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
	public int ingressos=0;
	public int meia=0;

	public Principal() {
		cineUcs = new Cinema();
		System.out.println(resgatarDados());
	}

	public static void main(String[] args) {
		Principal pr = new Principal();
		pr.menu();
	}

	public void menu() {
		sc = new Scanner(System.in);
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
			switch (opcao) {
			case 1:
				comprarIngresso();
			case 2:
				System.out.println(cineUcs.filmesCatalago());
				menu();
			case 3:
				menuCadastrar();
			case 4:
				System.out.println("-----------------------");
				System.out.println("Gravando dados e finalizado o sistema");
				gravarDados();
				System.exit(4);
			
			}
		} while (opcao != 0);
		sc.close();
	}

		public void comprarIngresso() {
		System.out.println(cineUcs.filmesCatalago());
		System.out.println("Selecione o filme: ");
		sc.next();
		//lê sala
		mostrarAssentos();
	}
	
	public void mostrarAssentos() {
		int l, poltrona, reserva;
		poltrona=-1;
		for(l=0;l<10;l++) {
			System.out.println((l + "0") + " " + (l + "1") + " " + (l + "2") + " " + (l + "3") 
					+ " " + (l + "4") + " " + (l + "5") + " " + (l + "6")
					+ " " + (l + "7") + " " + (l + "8") + " " + (l + "9"));
		}
		System.out.println("escolha a poltrona desejada");
		poltrona = Integer.parseInt(sc.next());
		reserva=45;//lê arquivos das poltronas ja reservadas
		while(poltrona==reserva) {
			System.out.println("poltrona ja reservada");
			System.out.println("escolha outra poltrona desejada");
			poltrona = Integer.parseInt(sc.next());
		}
		while(poltrona <0 || poltrona > 99) {
			System.out.println("poltrona invalida");
			System.out.println("escolha outra poltrona desejada");
			poltrona = Integer.parseInt(sc.next());
		}
		System.out.println("Você possui desconto?");
		String desconto = sc.next();
		if(desconto.equalsIgnoreCase("s")) {
			meia++;
		} else {
			ingressos++;
		}
		reserva = poltrona;
		
		gravarDados();
		System.out.println("Gostaria de comprar outro ingresso?");
		String opcao = sc.next();
		if(opcao.equalsIgnoreCase("s")) {
			mostrarAssentos();
		} else {
			System.out.println("O total ficou " + ((ingressos * 26) + (meia * 13)));
			System.out.println("Voltando ao menu");
			menu();
		}
	}


	public void menuCadastrar() {

		int opcao = 0;
		do {
			System.out.println("-----------------------");
			System.out.println("----MENU CADASTRAR----");
			System.out.println("1 - Dados do Cinema");
			System.out.println("2 - Listar Salas do Cinema");
			System.out.println("3 - Adicionar/Alterar Filmes em Cartaz");
			System.out.println("4 - Adicionar Atores ao banco de dados");
			System.out.println("5 - Adicionar diretores ao banco de dados");
			System.out.println("6 - Voltar ao menu Principal");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				dadosCinema();
			case 2:
				listarSalasCinema();
			case 3:
				dadosFilmesCinema();
			case 4:
				addAtorBanco();
			case 5:
				addDiretorBanco();
			case 6:
				menu();
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
		System.out.println("Adicionar sala ao Cinema? [S] sim / [N] não");
		res = sc.nextLine();
		if (res.equalsIgnoreCase(s)) {
			cineUcs.addSala();
			System.out.println(gravarDados());
			do {
				System.out.println("Adicionar outra sala ao Cinema? [S] sim / [N] não");
				res = sc.nextLine();
				cineUcs.addSala();
				System.out.println(gravarDados());
			} while (res.equalsIgnoreCase(s));
		}
		System.out.println("Remover alguma sala do cinema? [S] sim / [N] não");
		res = sc.nextLine();
		if (res.equalsIgnoreCase(s)) {
			int opcao;
			System.out.println(cineUcs.listarSalas());
			opcao = sc.nextInt();
			sc.nextLine();
			cineUcs.removeSala(cineUcs.selecionarSala(opcao));
			System.out.println(gravarDados());
			do {
				System.out.println("Adicionar outra sala ao Cinema? [S] sim / [N] não");
				res = sc.nextLine();
				cineUcs.addSala();
				System.out.println(gravarDados());
			} while (res.equalsIgnoreCase(s));
		}
		System.out.println("Retornando ao menu cadastrar");
		menuCadastrar();
	}

	public void dadosFilmesCinema() {
		String res;
		int opcao;

		System.out.println("-----------------------");
		System.out.println(cineUcs.filmesCatalago());
		System.out.println("1 - Adicionar filme ao Catálago");
		System.out.println("2 - Alterar dados de filme em cartaz");
		System.out.println("3 - Remover filme em cartaz");
		System.out.println("4 - Retornar ao menu cadastrar");
		opcao = sc.nextInt();
		sc.nextLine();
		switch (opcao) {
		case 1:
			System.out.println("-----------------------");
			System.out.println("Adicionando filme ao catálago");
			System.out.println("Qual o nome do filme?");
			res = sc.nextLine();
			System.out.println(cineUcs.addFilme(res));
			gravarDados();
			dadosFilmesCinema();
		case 2:
			System.out.println("-----------------------");
			System.out.println("Selecione o filme");
			System.out.println(cineUcs.filmesCatalago());
			System.out.println("Digite o número correspondente do filme:");
			opcao = sc.nextInt();
			alterarDadosFilme(cineUcs.selecionarFilme(opcao));
			gravarDados();
			dadosFilmesCinema();
		case 3:
			System.out.println("-----------------------");
			System.out.println("Selecione o filme");
			System.out.println(cineUcs.filmesCatalago());
			System.out.println("Digite o número correspondente do filme:");
			opcao = sc.nextInt();
			cineUcs.removeFilme(cineUcs.selecionarFilme(opcao));
			gravarDados();
			dadosFilmesCinema();
		case 4:
			menuCadastrar();
		}

	}

	public void alterarDadosFilme(Filme filme) {
		int opcao = 0;
		int subOpcao = 0;
		String res;
		if (filme != null) {
			System.out.println("O filme selecionado foi:" + filme.getNome());
			do {
				System.out.println("-----------------------");
				System.out.println("Alterar quais dados do filme?");
				System.out.println("1 - Nome do Filme");
				System.out.println("2 - Duração do filme");
				System.out.println("3 - Ano do filme");
				System.out.println("4 - Gênero do filme");
				System.out.println("5 - Sinapse do filme");
				System.out.println("6 - Horários apresentado do filme");
				System.out.println("7 - Elenco do Filme");
				System.out.println("8 - Diretores do filme");
				System.out.println("9 - Voltar ao menu anterior");
				opcao = sc.nextInt();
				sc.nextLine();
				switch (opcao) {
				case 1:
					System.out.println("-----------------------");
					System.out.println("Digite o novo nome do filme");
					filme.setNome(sc.nextLine());
					gravarDados();
					dadosFilmesCinema();
				case 2:
					System.out.println("-----------------------");
					System.out.println("Digite a nova duração do filme");
					filme.setDuracao(sc.nextLine());
					opcao = 0;
				case 3:
					System.out.println("-----------------------");
					System.out.println("Digite o ano do filme");
					filme.setAno(sc.nextLine());
					opcao = 0;
				case 4:
					System.out.println("-----------------------");
					subOpcao = 0;
					do {
						System.out.println("Selecione o gênero do filme");
						System.out.println(filme.listarGeneros());
						System.out.println("0 - Caso não tenha o gênero que procura e queira adicionar um gênero.");
						subOpcao = sc.nextInt();
						sc.nextLine();
						if (subOpcao == 0) {
							System.out.println("Digite o nome do gênero que queira adicionar");
							res = sc.nextLine();
							System.out.println(filme.addGeneroALista(res));
						} else {
							System.out.println(filme.setGenero(subOpcao));
							System.out.println(filme.listarGeneros());

						}
						System.out.println("Adicionar outro gênero ao filme? [S] sim / [N] não");
						res = sc.nextLine();
						System.out.println("");

					} while (res.equalsIgnoreCase("s"));
					filme.setDuracao(sc.nextLine());
					opcao = 0;
				case 5:
					System.out.println("-----------------------");
					System.out.println("Digite a sinapse do filme");
					filme.setDuracao(sc.nextLine());
					opcao = 0;
				case 6:
					System.out.println("-----------------------");
					System.out.println("Datas, horários e salas que o filme será apresentado");
					System.out.println(filme.listarHorarios());
					do {
						System.out.println("Gostaria de acressentar outro horário? [S] - sim / [N] não");
						res = sc.nextLine();
						if (res.equalsIgnoreCase("s")) {
							String data;
							String hora;
							System.out.println("Digite a data: exemplo: [20/12/2023]");
							data = sc.nextLine();
							System.out.println("Digite o horario: exemplo: [15:00] ");
							hora = sc.nextLine();
							System.out.println("Escolha a Sala:");
							System.out.println(cineUcs.listarSalas());
							subOpcao = sc.nextInt();
							filme.addHorarios(data, hora, cineUcs.selecionarSala(subOpcao));
							System.out.println("-----------------------");
							System.out.println(filme.listarHorarios());
							subOpcao = 0;
						} else {
							subOpcao = 1;
						}
					} while (subOpcao != 0);

					do {
						System.out.println("Gostaria de remover algum horário? [S] - sim / [N] não");
						if (res.equalsIgnoreCase("s")) {
							System.out.println("Escolha o horário");
							System.out.println(filme.listarHorarios());
							subOpcao = sc.nextInt();
							System.out.println(filme.removeHorario(filme.selecionarHorario(subOpcao)));
							subOpcao = 0;
						} else {
							subOpcao = 1;
						}

					} while (subOpcao != 0);

					opcao = 0;
				case 7:
					System.out.println("-----------------------");

					opcao = 0;
				case 8:
					System.out.println("-----------------------");

					opcao = 0;
				case 9:
					System.out.println("-----------------------");
					System.out.println("Retornando para o menu cadastro");
					menuCadastrar();
				}

			} while (opcao != 0);
		} else

		{
			System.out.println("-----------------------");
			System.out.println("Não foi possível selecionar nenhum filme");
			menu();
		}

	}

	public void addAtorBanco() {
		menu();
	}

	public void addDiretorBanco() {
		menu();
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
			System.out.println("-----------------------");
			System.out.println("O arquivo raiz não foi inicializado, será criado um arquivo vazio para isso.");
			gravarDados();
			resgatarDados();
		} catch (ClassNotFoundException e) {
			System.out.println("-----------------------");
			System.out.println(
					"O programa não possui todas as classes para o inicio do arquivo raiz, não será possível executar-lo.");
		}
		System.out.println("-----------------------");
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
			return "Dados não foram gravados";
		}
		return "Dados gravados com sucesso";
	}

}
