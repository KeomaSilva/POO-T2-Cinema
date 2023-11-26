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

	public String listarHorarios() {
		StringBuilder str = new StringBuilder();
		Collections.sort(horarios);
		for (int i = 0; i < horarios.size(); i++) {
			str.append(horarios.get(i));
		}
		return str.toString();
	}

	public void addHorarios(String data, String horario, Sala sala) {

		horarios.add(new Horario(data, horario, sala));

	}

	public Horario selecionarHorario(int index) {
		Horario x = null;
		Collections.sort(horarios);
		try {
			for (int i = 0; i < horarios.size(); i++) {
				if (i == index - 1) {
					x = horarios.get(i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public String removeHorario(Horario removeHorario) {
		String res = "";
		Collections.sort(horarios);
		if (removeHorario != null) {
			for (Horario horario : horarios) {
				if (horario.equals(removeHorario)) {
					horarios.remove(removeHorario);
					res = "Horário retirado";
				}
			}
		} else {
			res = "Hoario não encontrado";
		}

		return res;
	}

	public String addAtores(String nome) {
		String res = "";
		boolean possui = false;
		for (Ator ator : atores) {
			if (nome.equalsIgnoreCase(ator.getNome())) {
				possui = true;
				break;
			}
		}
		if (possui) {
			res = "O ator já está presente no elenco";
		} else {
			atores.add(new Ator(nome));
			res = "Ator adicionado ao elenco";
		}
		return res;

	}

	public String addDiretores(String nome) {
		String res = "";
		boolean possui = false;
		for (Diretor diretor : this.diretores) {
			if (nome.equalsIgnoreCase(diretor.getNome())) {
				possui = true;
				break;
			}
		}
		if (possui) {
			res = "Dirtetor já está presenta na lista";
		} else {
			diretores.add(new Diretor(nome));
			res = "Diretor adicionado ao filme";
		}
		return res;
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
