package Cine;

import java.io.Serializable;

public class Diretor extends Pessoa implements Serializable, Comparable<Diretor> {
	private static final long serialVersionUID = 1L;

	public Diretor(String nome) {
		this.setNome(nome);
	}

	public String toString() {
		return this.getNome();
	}

	@Override
	public int compareTo(Diretor o) {
		return this.getNome().compareTo(o.getNome());
	}

}
