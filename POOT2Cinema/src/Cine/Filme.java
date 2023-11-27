package Cine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Filme implements Serializable, Comparable<Filme> {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String descricao;
	private String duracao;
	private String ano;
	private List<Genero> generos;
	private List<Horario> horarios;
	private List<Ator> atores;
	private List<Diretor> diretores;
	private List<Ingresso> ingressos;

	public Filme() {
		generos = new ArrayList<>();
		horarios = new ArrayList<>();
		atores = new LinkedList<>();
		diretores = new LinkedList<>();
		ingressos = new ArrayList<>();
	}

	public Filme(String nome) {
		this();
		this.nome = nome;
	}

	public String toString() {

		StringBuilder str = new StringBuilder();
		str.append("Filme: " + this.nome + " - ");
		str.append("Ano: " + this.ano + "-");
		str.append("Duração:" + this.duracao + " - ");
		str.append("Gênero: ");
		for (Genero genero : generos) {
			str.append(genero + " ,");
		}
		str.append("- Horários: ");
		for (Horario horario : horarios) {
			str.append(horario + ", ");
		}
		str.append("- Sinapse: " + this.descricao + " - ");
		str.append("Diretor(a): ");
		for (Diretor diretor : diretores) {
			str.append(diretor + " ,");
		}
		str.append("- Elenco: ");
		for (Ator ator : atores) {
			str.append(ator + " ,");
		}

		return str.toString();
	}

	public String getGeneros() {
		StringBuilder str = new StringBuilder();
		Collections.sort(generos);
		str.append("Gênero: ");
		if (generos == null) {
			str.append("Lista vazia");
		} else {
			for (Genero genero : generos) {
				str.append(genero.getNome() + ", ");
			}
		}

		return str.toString();

	}

	public String listarGenerosFilme() {
		StringBuilder str = new StringBuilder();
		try {
			Collections.sort(generos);
			for (int i = 0; i < generos.size(); i++) {
				str.append(i + 1 + ": " + generos.get(i).getNome());
				str.append("\n");
			}

		} catch (Exception e) {

		}
		return str.toString();
	}

	public String setGenero(Genero genero) {
		StringBuilder str = new StringBuilder();
		try {
			if (generos == null) {
				generos.add(genero);
				str.append("Gênero adicionado");
			} else {
				Collections.sort(generos);
				int count = 0;
				if (generos.size() == 0) {
					generos.add(genero);
					str.append("Gênero selecionado: " + genero.getNome());
					str.append("Gênero adicionado à lista");
				} else {
					for (Genero g : generos) {
						if (g.getNome().equalsIgnoreCase(genero.getNome())) {
							str.append("Gênero já presente na lista");
							count++;
							break;
						}
					}
				}
				if (count == 0) {
					generos.add(genero);
					str.append("Gênero selecionado: " + genero.getNome());
					str.append("Gênero adicionado à lista");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str.toString();

	}

	public String removeGeneros(int index) {
		StringBuilder str = new StringBuilder();
		try {
			Collections.sort(generos);
			generos.remove(index - 1);
			str.append("Gênero removido do filme");

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return str.toString();

	}

	public String getHorarios() {
		StringBuilder str = new StringBuilder();
		Collections.sort(horarios);
		str.append("Horários: ");
		if (generos == null) {
			str.append("Lista vazia");
		} else {
			for (Horario horario : horarios) {
				str.append(horario + ", ");
				str.append("\n");
			}
		}

		return str.toString();

	}

	public String listarHorariosFilme() {
		StringBuilder str = new StringBuilder();
		try {
			Collections.sort(horarios);
			for (int i = 0; i < horarios.size(); i++) {
				str.append(i + 1 + ": " + horarios.get(i));
				str.append("\n");
			}

		} catch (Exception e) {

		}
		return str.toString();
	}

	public String setHorario(Horario horario) {
		StringBuilder str = new StringBuilder();
		try {
			if (horarios == null) {
				horarios.add(horario);
				str.append("Horário adicionado");
			} else {
				Collections.sort(horarios);
				int count = 0;
				if (horarios.size() == 0) {
					horarios.add(horario);
					str.append("Horário selecionado: " + horario);
					str.append("Horário adicionado à lista");
				} else {
					for (Horario h : horarios) {
						if (h.getDataString().equalsIgnoreCase(horario.getDataString())) {
							str.append("Horário já presente na lista");
							count++;
							break;
						}
					}
					if (count == 0) {
						horarios.add(horario);
						str.append("Horário selecionado: " + horario);
						str.append("Horário adicionado à lista");
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str.toString();

	}

	public String removeHorario(int index) {
		StringBuilder str = new StringBuilder();
		try {
			Collections.sort(horarios);
			horarios.remove(index-1);
			str.append("Horário removido do filme");

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return str.toString();

	}

	public String getElenco() {
		StringBuilder str = new StringBuilder();
		Collections.sort(atores);
		str.append("Elenco: ");
		if (atores == null) {
			str.append("Lista vazia");
		} else {
			for (Ator ator : atores) {
				str.append(ator.getNome() + "\n");
			}
		}

		return str.toString();

	}

	public String listarElencoFilme() {
		StringBuilder str = new StringBuilder();
		try {
			Collections.sort(atores);
			for (int i = 0; i < atores.size(); i++) {
				str.append(i + 1 + ": " + atores.get(i).getNome());
				str.append("\n");
			}

		} catch (Exception e) {

		}
		return str.toString();
	}

	public String setElenco(Ator ator) {
		StringBuilder str = new StringBuilder();
		try {
			if (generos == null) {
				atores.add(ator);
				str.append("Ator adicionado");
			} else {
				Collections.sort(atores);
				int count = 0;
				if (atores.size() == 0) {
					atores.add(ator);
					str.append("Ator selecionado: " + ator.getNome());
					str.append("Ator adicionado à lista");
				} else {
					for (Ator a : atores) {
						if (a.getNome().equalsIgnoreCase(ator.getNome())) {
							str.append("Ator já presente na lista");
							count++;
							break;
						}
					}
				}
				if (count == 0) {
					atores.add(ator);
					str.append("Ator selecionado: " + ator.getNome());
					str.append("Ator adicionado à lista");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str.toString();

	}

	public String removeAtores(int index) {
		StringBuilder str = new StringBuilder();
		try {
			Collections.sort(atores);
			atores.remove(index - 1);
			str.append("Ator removido do filme");

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return str.toString();

	}

	public String getDiretores() {
		StringBuilder str = new StringBuilder();
		Collections.sort(diretores);
		str.append("Direrores: ");
		if (diretores == null) {
			str.append("Lista vazia");
		} else {
			for (Diretor diretor : diretores) {
				str.append(diretor.getNome() + "\n");
			}
		}

		return str.toString();

	}

	public String listarDiretorFilme() {
		StringBuilder str = new StringBuilder();
		try {
			Collections.sort(diretores);
			for (int i = 0; i < diretores.size(); i++) {
				str.append(i + 1 + ": " + diretores.get(i).getNome());
				str.append("\n");
			}

		} catch (Exception e) {

		}
		return str.toString();
	}

	public String setDiretor(Diretor diretor) {
		StringBuilder str = new StringBuilder();
		try {
			if (generos == null) {
				diretores.add(diretor);
				str.append("Diretor adicionado");
			} else {
				Collections.sort(diretores);
				int count = 0;
				if (diretores.size() == 0) {
					diretores.add(diretor);
					str.append("Diretor selecionado: " + diretor.getNome());
					str.append("Diretor adicionado à lista");
				} else {
					for (Diretor d : diretores) {
						if (d.getNome().equalsIgnoreCase(diretor.getNome())) {
							str.append("Diretor já presente na lista");
							count++;
							break;
						}
					}
				}
				if (count == 0) {
					diretores.add(diretor);
					str.append("Diretor selecionado: " + diretor.getNome());
					str.append("Diretor adicionado à lista");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str.toString();

	}

	public String removeDiretor(int index) {
		StringBuilder str = new StringBuilder();
		try {
			Collections.sort(diretores);
			diretores.remove(index - 1);
			str.append("Diretor removido do filme");

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return str.toString();

	}

	public String lugaresVagos() {
		StringBuilder str = new StringBuilder();
//		str.append("----- FUNDO -----\n");
//		for (int i = 9; i >= 0; i--) {
//			str.append("Linha " + i + ":");
//			for (int j = 1; j <= 10;) {
//				if (j < 10) {
//					String codigo = i + "" + j;
//					if (this.ingressos.containsKey(codigo)) {
//						str.append("- X -");
//					} else {
//						str.append("- " + i + "" + j);
//					}
//				} else {
//					String codigo = i + 1 + "" + j;
//					if (this.ingressos.containsKey(codigo)) {
//						str.append("- X -");
//					} else {
//						str.append("- " + i + 1 + "0 -");
//					}
//				}
//			}
//			str.append("\n");
//		}
		str.append("\n----- TELA -----");
		return str.toString();

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		if (descricao == null) {
			return "Não foi cadastrado Sinapse do filme";
		}
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Override
	public int compareTo(Filme o) {
		return this.nome.compareTo(o.nome);
	}

}
