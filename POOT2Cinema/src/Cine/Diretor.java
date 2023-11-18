package Cine;

import java.io.Serializable;

public class Diretor extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	public Diretor(String nome) {
		this.setNome(nome);
	}

	public String toString() {
		return this.getNome();
	}

}
