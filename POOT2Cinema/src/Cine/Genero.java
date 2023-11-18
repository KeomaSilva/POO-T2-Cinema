package Cine;

import java.io.Serializable;

public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;

	public Genero(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
