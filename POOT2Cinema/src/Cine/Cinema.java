package Cine;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Cinema implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String endereco;
	private Set<Filme> filmes;
	private Set<Sala> salas;

	public Cinema() {
		salas = new HashSet<>();
		filmes = new TreeSet<>();
	}

	public Cinema(String nome, String endereco, int nsalas) {
		this();
		this.nome = nome;
		this.endereco = endereco;
		for (int i = 1; i <= nsalas;) {
			salas.add(new Sala(i));
		}

	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("------------------");
		str.append("Nome: " + this.nome);
		str.append("Endereço: " + this.endereco);
		str.append("Quantidades de filmes em cartaz: " + this.filmes.size());
		str.append("Quantidade de salas: " + this.salas.size());
		return str.toString();
	}

	public void addFilme() {
		filmes.add(new Filme());
	}

	public void addSala() {
		int index = this.salas.size();
		this.salas.add(new Sala(index + 1));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
