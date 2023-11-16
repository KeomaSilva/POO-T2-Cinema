package Cine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cinema implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String endereco;
	private Filme filme;
	private List<Sala> salas;

	public Cinema(String nome, String endereco, int nsalas) {
		salas = new ArrayList<>();
		this.nome = nome;
		this.endereco = endereco;
		for (int i = 1; i <= nsalas;) {
			salas.add(new Sala(i));
		}

	}

	public void addSala(int numero) {
		this.salas.add(new Sala(numero));
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

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}
