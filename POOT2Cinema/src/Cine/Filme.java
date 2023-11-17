package Cine;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String descricao;
	private String duracao;
	private String ano;
	private Genero genero;
	private Set<Horario> horarios;
	private Set<Ator> atores;
	private Set<Diretor> diretores;

	public Filme(String nome, String descricao, String duracao, String ano, String genero) {
		this.nome = nome;
		this.descricao = descricao;
		this.duracao = duracao;
		this.genero = new Genero(genero);
		horarios = new HashSet<>();
		atores = new HashSet<>();
		diretores = new HashSet<>();
	}

	public void addHorarios(String data, String horario, Sala sala) {

		horarios.add(new Horario(data, horario, sala));

	}
	public void addAtores() {
		
	}
	public void addDiretores() {
		
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

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
