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
		Filme filme;
		Horario horarioSelecionado;
		String res;
		String res2;
		String nomeCliente;
		String celular;
		String meiaEntrada;
		int opcao;
		int assentoEscolhido;

		System.out.println("-----------------------");
		System.out.println("----COMPRAR INGRESSO----");
		System.out.println("Selecione o filme em cartaz");
		System.out.println(cineUcs.filmesCatalago());
		System.out.println("Digite o número correspondente do filme:");
		opcao = sc.nextInt();
		filme = cineUcs.selecionarFilme(opcao);
		if (filme != null) {
			System.out.println("O filme selecionado foi:");
			System.out.println(filme);
			System.out.println("Selecione o Horário de exibição");
			System.out.println(filme.listarHorariosFilme());
			System.out.println("0 - Voltar para o menu");
			opcao = sc.nextInt();
			sc.nextLine();
			try {
				if (opcao == 0) {
					System.out.println("Retornando ao menu principal");
					menu();
				} else {
					do {
						horarioSelecionado = filme.selecionarHorarioFilme(opcao);
						System.out.println("Horário: " + horarioSelecionado);
						System.out.println("Deseja continuar para a seleção do assento? [S] sim / [N] não");
						res = sc.nextLine();
						if (res.equalsIgnoreCase("s")) {
							do {

								System.out.println("Selecione o assento que deseja");
								System.out.println(horarioSelecionado.matrixSala());
								System.out.println("Digite o número correspondente do assento disponíveis");
								assentoEscolhido = sc.nextInt();
								while (assentoEscolhido > 99 || assentoEscolhido < 0) {
									System.out.println("Assento não existente, por favor escolha outro.");
									assentoEscolhido = sc.nextInt();
								}

								sc.nextLine();
								System.out.println("Nome do comprador:");
								nomeCliente = sc.nextLine();
								System.out.println("Celular para contato:");
								celular = sc.nextLine();
								System.out.println("Ingresso meia-entrada?[S] sim / [N] não");
								meiaEntrada = sc.nextLine();

								if (cineUcs.getDatabase().getIngressoDataBase() != null) {
									for (String ingressoBase : cineUcs.getDatabase().getIngressoDataBase()) {
										if (ingressoBase.equalsIgnoreCase(
												horarioSelecionado.getCodigoHorario() + assentoEscolhido)) {
											System.out.println("Outro filme possui esse mesmo horário,sala e data.");
											menu();
										}
									}
								}

								System.out.println(
										horarioSelecionado.ingressoComprado(horarioSelecionado.getCodigoHorario(),
												assentoEscolhido, filme, horarioSelecionado, nomeCliente, celular,
												horarioSelecionado.getSala(), meiaEntrada));
								System.out.println("Horário selecionado: " + horarioSelecionado);
								System.out.println("Assento escolhido: " + assentoEscolhido);
								gravarDados();
								System.out.println("Deseja comprar outro assento? [S] sim / [N] não");
								res2 = sc.nextLine();
								if (!res2.equalsIgnoreCase("s")) {
									res = "n";
								}
							} while (res2.equalsIgnoreCase("s"));

						} else {
							System.out.println("Cancelando e retornando ao menu principal");
							gravarDados();
							menu();
						}
					} while (res.equalsIgnoreCase("s"));

				}
			} catch (Exception e) {
				System.out.println("Error - retornando ao menu principal");
				menu();
			}
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
				try {
					int fileira;
					int coluna;
					System.out.println("Digite o numero de fileiras na sala:");
					fileira = sc.nextInt();
					sc.nextLine();
					System.out.println("Digite o númeor de colunas na sala:");
					coluna = sc.nextInt();
					sc.nextLine();
					cineUcs.addSala(fileira, coluna);
					System.out.println(gravarDados());
					System.out.println("Adicionar outra sala ao Cinema? [S] sim / [N] não");
					res = sc.nextLine();
				} catch (Exception e) {
					System.out.println("Digite um número para as respostas, exceto quando pede para continuar");
					listarSalasCinema();
				}
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
							System.out.println("0 - Caso não tenha o gênero que procura (Adicionar ao Banco de Dados)");
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
						opcao = 0;
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
						opcao = 0;
					}
					if (escolha == 3) {
						opcao = 0;
					}
				}
				if (opcao == 5) {
					System.out.println("-----------------------");
					System.out.println("Sinapse atual: ");
					System.out.println(filme.getDescricao());
					System.out.println("Alterar a Sinapse do Filme? [S] - sim / [N] não");
					res = sc.nextLine();
					if (res.equalsIgnoreCase("s")) {
						System.out.println("Digite a sinapse do filme");
						filme.setDescricao(sc.nextLine());
						System.out.println(gravarDados());
						opcao = 0;
					} else {
						opcao = 0;
					}
				}
				if (opcao == 6) {
					System.out.println("-----------------------");
					System.out.println("Datas, horários e salas que o filme será apresentado");
					do {
						String data;
						int hora;
						System.out.println(filme.listarHorariosFilme());
						System.out.println("Gostaria de acressentar outro horário? [S] - sim / [N] não");
						res = sc.nextLine();

						try {

							if (res.equalsIgnoreCase("s")) {
								System.out.println("Digite a data: exemplo: [20/12/2023]");
								data = sc.nextLine();
								System.out.println("Escolha o horário do filme:");
								System.out.println("1 - 15:00");
								System.out.println("2 - 18:00");
								System.out.println("3 - 21:00");
								hora = sc.nextInt();
								sc.nextLine();
								System.out.println("Escolha a Sala:");
								System.out.println(cineUcs.listarSalas());
								subOpcao = sc.nextInt();
								sc.nextLine();
								String dataReplace = data.replace("/", " ");
								String[] dataRepartida = dataReplace.split(" ");
								String dataInvertida = dataRepartida[2] + dataRepartida[1] + dataRepartida[0];
								String codigoHorario = dataInvertida + opcao + cineUcs.selecionarSala(subOpcao);
								try {

									if (cineUcs.getDatabase().getHorariosDataBase() != null) {
										for (String horarioBase : cineUcs.getDatabase().getHorariosDataBase()) {
											if (horarioBase.equalsIgnoreCase(codigoHorario)) {
												System.out
														.println("Outro filme possui esse mesmo horário,sala e data.");
												opcao = 0;
											}
										}
									}
								} catch (Exception e) {
									System.out.println("Horário já existe");
								}
								cineUcs.getDatabase().adicionarHorariosALista(codigoHorario);
								filme.setHorario(new Horario(data, hora, cineUcs.selecionarSala(subOpcao)));
								System.out.println(gravarDados());
								System.out.println("-----------------------");
								subOpcao = 0;
							} else {
								subOpcao = 1;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} while (subOpcao == 0);

					do {
						System.out.println("Gostaria de remover algum horário? [S] - sim / [N] não");
						res = sc.nextLine();
						if (res.equalsIgnoreCase("s")) {
							System.out.println("Escolha o horário");
							System.out.println(filme.listarHorariosFilme());
							subOpcao = sc.nextInt();
							sc.nextLine();
							System.out.println(filme.removeHorario(subOpcao));
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
					int escolha;
					subOpcao = 0;
					System.out.println(filme.getElenco());
					System.out.println("Selecione a opção:");
					System.out.println("1 - Adicionar Ator/Atriz ao elenco");
					System.out.println("2 - Remover Ator/Atriz ao elenco");
					System.out.println("3 - Retornar ao menu anterior");
					escolha = sc.nextInt();
					sc.nextLine();
					if (escolha == 1) {
						do {
							System.out.println(cineUcs.getDatabase().listarAtores());
							System.out.println(
									"0 - Caso não tenha o ator/atriz que procura (adicionar ao Banco de Dados)");
							subOpcao = sc.nextInt();
							sc.nextLine();
							if (subOpcao == 0) {
								System.out.println("Digite o nome do ator/atriz que queira adicionar");
								res = sc.nextLine();
								System.out.println(cineUcs.getDatabase().adicionarAtoresALista(res));
								gravarDados();
							} else {
								System.out.println(
										filme.setElenco(cineUcs.getDatabase().selecionarAtoresDaLista(subOpcao)));
								gravarDados();
							}
							System.out.println("Adicionar outro ator/atriz ao elenco? [S] sim / [N] não");
							res = sc.nextLine();
						} while (res.equalsIgnoreCase("s"));
						opcao = 0;
					}
					if (escolha == 2) {
						do {
							System.out.println("Selecione o ator/atriz do elenco");
							System.out.println(filme.listarElencoFilme());
							subOpcao = sc.nextInt();
							sc.nextLine();
							System.out.println(filme.removeAtores(subOpcao));
							gravarDados();
							System.out.println("Remover outro ator/atriz do elenco? [S] sim / [N] não");
							res = sc.nextLine();

						} while (res.equalsIgnoreCase("s"));

						System.out.println(gravarDados());
						opcao = 0;
					}
					if (escolha == 3) {
						opcao = 0;
					}

					opcao = 0;

				}
				if (opcao == 8) {
					System.out.println("-----------------------");
					int escolha;
					subOpcao = 0;
					System.out.println(filme.getDiretores());
					System.out.println("Selecione a opção:");
					System.out.println("1 - Adicionar diretor ao filme");
					System.out.println("2 - Remover diretor ao filme");
					System.out.println("3 - Retornar ao menu anterior");
					escolha = sc.nextInt();
					sc.nextLine();
					if (escolha == 1) {
						do {
							System.out.println(cineUcs.getDatabase().listarDiretores());
							System.out
									.println("0 - Caso não tenha o diretor que procura (adicionar ao Banco de Dados)");
							subOpcao = sc.nextInt();
							sc.nextLine();
							if (subOpcao == 0) {
								System.out.println("Digite o nome do diretor que queira adicionar");
								res = sc.nextLine();
								System.out.println(cineUcs.getDatabase().adicionarDiretorALista(res));
								gravarDados();
							} else {
								System.out.println(
										filme.setDiretor(cineUcs.getDatabase().selecionarDiretorDaLista(subOpcao)));
								gravarDados();
							}
							System.out.println("Adicionar outro diretor ao filme? [S] sim / [N] não");
							res = sc.nextLine();
						} while (res.equalsIgnoreCase("s"));
						opcao = 0;
					}
					if (escolha == 2) {
						do {
							System.out.println("Selecione o diretor do filme");
							System.out.println(filme.listarDiretorFilme());
							subOpcao = sc.nextInt();
							sc.nextLine();
							System.out.println(filme.removeDiretor(subOpcao));
							gravarDados();
							System.out.println("Remover outro diretor do filme? [S] sim / [N] não");
							res = sc.nextLine();

						} while (res.equalsIgnoreCase("s"));

						System.out.println(gravarDados());
						opcao = 0;
					}
					if (escolha == 3) {
						opcao = 0;
					}

					opcao = 0;

				}
				if (opcao == 9) {
					System.out.println("-----------------------");
					System.out.println("Retornando para o menu cadastro");
					dadosFilmesCinema();

				}

			} while (opcao <= 0);
		} else {
			System.out.println("-----------------------");
			System.out.println("Não foi possível selecionar nenhum filme");
			menuCadastrar();
		}

	}

	public void addAtorBanco() {
		String res;
		int opcao;
		System.out.println("-----------------------");
		System.out.println("Todos os atores/atrizes do banco de dados");
		System.out.println(cineUcs.getDatabase().listarAtores());
		System.out.println("Gostaria de adicionar ator/atriz? [S] sim / [N] não");
		res = sc.nextLine();
		if (res.equalsIgnoreCase("s")) {
			do {
				System.out.println("Digite o nome do ator/atriz que queira adicionar");
				res = sc.nextLine();
				System.out.println(cineUcs.getDatabase().adicionarAtoresALista(res));
				gravarDados();
				System.out.println("Gostaria de adicionar mais atores? [S] sim / [N] não");
				res = sc.nextLine();
			} while (res.equalsIgnoreCase("s"));

		}
		System.out.println("Gostaria de remover algum ator/atriz? [S] sim / [N] não");
		res = sc.nextLine();
		if (res.equalsIgnoreCase("s")) {
			do {
				System.out.println("Selecione o ator/atriz");
				System.out.println(cineUcs.getDatabase().listarAtores());
				opcao = sc.nextInt();
				sc.nextLine();
				System.out.println(cineUcs.getDatabase().removeAtoresBanco(opcao));
				gravarDados();
				System.out.println("Remover outro ator/atriz? [S] sim / [N] não");
				res = sc.nextLine();
			} while (res.equalsIgnoreCase("s"));

		}
		menuCadastrar();
	}

	public void addDiretorBanco() {
		String res;
		int opcao;
		System.out.println("-----------------------");
		System.out.println("Todos os Diretores do banco de dados");
		System.out.println(cineUcs.getDatabase().listarDiretores());
		System.out.println("Gostaria de adicionar diretor? [S] sim / [N] não");
		res = sc.nextLine();
		if (res.equalsIgnoreCase("s")) {
			do {
				System.out.println("Digite o nome do diretor que queira adicionar");
				res = sc.nextLine();
				System.out.println(cineUcs.getDatabase().adicionarDiretorALista(res));
				gravarDados();
				System.out.println("Gostaria de adicionar mais diretores? [S] sim / [N] não");
				res = sc.nextLine();
			} while (!res.equalsIgnoreCase("s"));

		}
		System.out.println("Gostaria de remover algum diretor? [S] sim / [N] não");
		res = sc.nextLine();
		if (res.equalsIgnoreCase("s")) {
			do {
				System.out.println("Selecione o diretor");
				System.out.println(cineUcs.getDatabase().listarDiretores());
				opcao = sc.nextInt();
				sc.nextLine();
				System.out.println(cineUcs.getDatabase().removeDiretorBanco(opcao));
				gravarDados();
				System.out.println("Remover outro diretor? [S] sim / [N] não");
				res = sc.nextLine();
			} while (!res.equalsIgnoreCase("s"));

		}
		menuCadastrar();
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