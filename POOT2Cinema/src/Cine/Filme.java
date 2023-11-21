package Cine;

import java.io.Serializable;
import java.util.ArrayList;
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

	public void addHorarios(String data, String horario, Sala sala) {

		horarios.add(new Horario(data, horario, sala));

	}

	public String addAtores(String nome) {
		String res = "";
		boolean possui = false;
		for (Ator ator : this.atores) {
			if (nome.equalsIgnoreCase(ator.getNome())) {
				possui = true;
				break;
			}
		}
		if (possui) {
			res = "O ator já está presente no elenco";
		} else {
			atores.add(new Ator(nome));
			res = "Ator adicionado no elenco";
		}
		return res;

	}

	public void addDiretores(String nome) {
		for (Diretor diretor : this.diretores) {
			if (nome.equalsIgnoreCase(diretor.getNome())) {

			}
			;
		}
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
