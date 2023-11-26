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
	private Genero genero;
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

	public String listarGeneros() {
		StringBuilder str = new StringBuilder();
		Collections.sort(generos);
		for (int i = 0; i < generos.size(); i++) {
			String index = "" + (i + 1);
			str.append(index + " - " + generos.get(i).getNome());
			str.append("\n");
		}

		return str.toString();
	}

	public String setGenero(int id) {
		StringBuilder str = new StringBuilder();
		Collections.sort(generos);
		str.append("Gênero selecionado: " + generos.get(id - 1).getNome());
		this.genero = generos.get(id - 1);
		str.append("Gênero alterado");
		return str.toString();

	}

	public String addGeneroALista(String nome) {
		String res = "";
		boolean possui = false;
		Collections.sort(generos);
		for (Genero genero : generos) {
			if (genero.getNome().equalsIgnoreCase(nome)) {
				possui = true;
				break;
			}
		}
		if (possui) {
			res = "O gênero já está presente na lista";
		} else {
			generos.add(new Genero(nome));
			res = "Gênero adicionado a lista de gêneros";
		}
		return res;
	}

	public String listarHorarios() {
		StringBuilder str = new StringBuilder();
		Collections.sort(horarios);
		for (int i = 0; i < horarios.size(); i++) {
			String index = "" + (i + 1);
			str.append(index + " - Data: " + horarios.get(i).getData() + " - " + horarios.get(i).getHorario()
					+ " - Sala: " + horarios.get(i).getSala());
			str.append("\n");
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

	public Genero getGenero() {
		return genero;
	}

	@Override
	public int compareTo(Filme o) {
		return this.nome.compareTo(o.nome);
	}

}
