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
			System.out.println("Bem Vindo ao Cinema: " + cineUcs.getNome());
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
			System.out.println("Altere o endereço do cinema:");
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
		do {
			if (res.equalsIgnoreCase(s)) {
				cineUcs.addSala();
				System.out.println(gravarDados());
				System.out.println("Adicionar outra sala ao Cinema? [S] sim / [N] não");
				res = sc.nextLine();
			}
		} while (res.equalsIgnoreCase(s));
		System.out.println("Remover alguma sala do cinema? [S] sim / [N] não");
		res = sc.nextLine();
		do {
			if (res.equalsIgnoreCase(s)) {
				int opcao;
				System.out.println(cineUcs.listarSalas());
				opcao = sc.nextInt();
				sc.nextLine();
				cineUcs.removeSala(cineUcs.selecionarSala(opcao));
				System.out.println(gravarDados());
				System.out.println("Remover outra sala do Cinema? [S] sim / [N] não");
				res = sc.nextLine();
			}
		} while (res.equalsIgnoreCase(s));
		System.out.println("Retornando ao menu cadastrar");
		menuCadastrar();
	}

	public void dadosFilmesCinema() {
		String res;
		int opcao;

		System.out.println("-----------------------");
		System.out.println("--- Adicionar/Alterar Filmes em Cartaz ---");
		System.out.println(cineUcs.filmesCatalago());
		System.out.println("1 - Adicionar filme ao Catálago");
		System.out.println("2 - Alterar dados de filme em cartaz");
		System.out.println("3 - Remover filme em cartaz");
		System.out.println("4 - Retornar ao menu cadastrar");
		opcao = sc.nextInt();
		sc.nextLine();
		if (opcao == 1) {
			System.out.println("-----------------------");
			System.out.println("Adicionando filme ao catálago");
			System.out.println("Qual o nome do filme?");
			res = sc.nextLine();
			System.out.println(cineUcs.addFilme(res));
			gravarDados();
			dadosFilmesCinema();
		}
		if (opcao == 2) {
			alterarDadosFilme();
		}
		if (opcao == 3) {
			System.out.println("-----------------------");
			System.out.println("Selecione o filme");
			System.out.println(cineUcs.filmesCatalago());
			System.out.println("Digite o número correspondente do filme:");
			opcao = sc.nextInt();
			cineUcs.removeFilme(cineUcs.selecionarFilme(opcao));
			gravarDados();
			dadosFilmesCinema();
		}
		if (opcao == 4) {
			menuCadastrar();
		}
	}

	public void alterarDadosFilme() {
		int opcao = 0;
		int subOpcao = 0;
		String res;
		Filme filme;

		System.out.println("-----------------------");
		System.out.println("Selecione o filme");
		System.out.println(cineUcs.filmesCatalago());
		System.out.println("Digite o número correspondente do filme:");
		opcao = sc.nextInt();
		filme = cineUcs.selecionarFilme(opcao);
		if (filme != null) {
			System.out.println("O filme selecionado foi:");
			System.out.println(filme);
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
				if (opcao == 1) {
					System.out.println("-----------------------");
					System.out.println("Digite o novo nome do filme");
					filme.setNome(sc.nextLine());
					System.out.println(gravarDados());
					dadosFilmesCinema();
				}
				if (opcao == 2) {
					System.out.println("-----------------------");
					System.out.println("Duração do filme: " + filme.getDuracao());
					System.out.println("Digite a nova duração do filme");
					filme.setDuracao(sc.nextLine());
					System.out.println(gravarDados());
					opcao = 0;
				}
				if (opcao == 3) {
					System.out.println("-----------------------");
					System.out.println("Ano de lançamento do filme: " + filme.getAno());
					System.out.println("Digite o ano do filme");
					filme.setAno(sc.nextLine());
					System.out.println(gravarDados());
					opcao = 0;
				}
				if (opcao == 4) {
					System.out.println("-----------------------");
					int escolha;
					subOpcao = 0;
					System.out.println("Gêneros do filme: " + filme.getGeneros());
					System.out.println("Selecione a opção:");
					System.out.println("1 - Adicionar Gênero ao Filme");
					System.out.println("2 - Remover Gênero do Filme");
					System.out.println("3 - Retornar ao menu anterior");
					escolha = sc.nextInt();
					sc.nextLine();
					if (escolha == 1) {
						do {
							System.out.println("Gêneros do filme: " + filme.getGeneros());
							System.out.println("Selecione o gênero do filme");
							System.out.println(cineUcs.getDatabase().listarGeneros());
							System.out.println("0 - Caso não tenha o gênero que procura e queira adicionar um gênero.");
							subOpcao = sc.nextInt();
							sc.nextLine();
							if (subOpcao == 0) {
								System.out.println("Digite o nome do gênero que queira adicionar");
								res = sc.nextLine();
								System.out.println(cineUcs.getDatabase().adicionarGeneroALista(res));
								gravarDados();
							} else {
								System.out.println(
										filme.setGenero(cineUcs.getDatabase().selecionarGeneroDaLista(subOpcao)));
								gravarDados();
							}
							System.out.println("Adicionar outro gênero ao filme? [S] sim / [N] não");
							res = sc.nextLine();
						} while (res.equalsIgnoreCase("s"));
						alterarDadosFilme();
					}
					if (escolha == 2) {
						do {
							System.out.println("Selecione o gênero do filme");
							System.out.println(filme.listarGenerosFilme());
							subOpcao = sc.nextInt();
							sc.nextLine();
							System.out.println(filme.removeGeneros(subOpcao));
							gravarDados();
							System.out.println("Remover gênero do filme? [S] sim / [N] não");
							res = sc.nextLine();

						} while (res.equalsIgnoreCase("s"));

						System.out.println(gravarDados());
						alterarDadosFilme();
					}
					if (escolha == 3) {
						alterarDadosFilme();
					}
				}
				if (opcao == 5) {
					System.out.println("-----------------------");
					System.out.println("Digite a sinapse do filme");
					filme.setDuracao(sc.nextLine());
					System.out.println(gravarDados());
					opcao = 0;
				}
				if (opcao == 6) {
					System.out.println("-----------------------");
					System.out.println("Datas, horários e salas que o filme será apresentado");
					do {
						String data;
						String hora;
						System.out.println(filme.listarHorarios());
						System.out.println("Gostaria de acressentar outro horário? [S] - sim / [N] não");
						res = sc.nextLine();
						if (res.equalsIgnoreCase("s")) {
							System.out.println("Digite a data: exemplo: [20/12/2023]");
							data = sc.nextLine();
							System.out.println("Digite o horario: exemplo: [15:00] ");
							hora = sc.nextLine();
							System.out.println("Escolha a Sala:");
							System.out.println(cineUcs.listarSalas());
							subOpcao = sc.nextInt();
							sc.nextLine();
							filme.addHorarios(data, hora, cineUcs.selecionarSala(subOpcao));
							System.out.println(gravarDados());
							System.out.println("-----------------------");
							subOpcao = 0;
						} else {
							subOpcao = 1;
						}
					} while (subOpcao == 0);

					do {
						System.out.println("Gostaria de remover algum horário? [S] - sim / [N] não");
						res = sc.nextLine();
						if (res.equalsIgnoreCase("s")) {
							System.out.println("Escolha o horário");
							System.out.println(filme.listarHorarios());
							subOpcao = sc.nextInt();
							sc.nextLine();
							System.out.println(filme.removeHorario(filme.selecionarHorario(subOpcao)));
							System.out.println(gravarDados());
							subOpcao = 0;
						} else {
							subOpcao = 1;
						}

					} while (subOpcao == 0);

					opcao = 0;
				}
				if (opcao == 7) {
					System.out.println("-----------------------");
					System.out.println("7 - Elenco do Filme");

					opcao = 0;

				}
				if (opcao == 8) {
					System.out.println("-----------------------");
					System.out.println("8 - Diretores do filme");
					opcao = 0;

				}
				if (opcao == 9) {
					System.out.println("-----------------------");
					System.out.println("Retornando para o menu cadastro");
					dadosFilmesCinema();

				}

			} while (opcao <= 0);
		} else

		{
			System.out.println("-----------------------");
			System.out.println("Não foi possível selecionar nenhum filme");
			menuCadastrar();
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