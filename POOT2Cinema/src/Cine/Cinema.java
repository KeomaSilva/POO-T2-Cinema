package Cine;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Cinema implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String endereco;
	private Set<Filme> filmes;
	private Set<Sala> salas;

	public Cinema() {
		salas = new LinkedHashSet<>();
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

	public void addFilme(String nome) {
		for (Filme filme : filmes) {
			if (filme.getNome() == nome) {
				filmes.add(filme);
			}else {
				filmes.add(new Filme(nome));				
			}
		}
	}

	public String getFilmes() {
		StringBuilder str = new StringBuilder();
		for(Filme filme:filmes) {
			str.append(filme);
		}
		str.append("Total de "+filmes.size()+" cadastrados");
		return str.toString();
	}

	public void addSala() {
		int index = this.salas.size();
		this.salas.add(new Sala(index + 1));
	}

	public String getSalas() {
		StringBuilder str = new StringBuilder();
		for (Sala sala : salas) {
			str.append("Sala: " + sala.getNumero() + " - ");
		}
		str.append("há um total de: "+salas.size()+" salas");
		return str.toString();
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
