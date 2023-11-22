package Cine;

import java.io.Serializable;

public class Ator extends Pessoa implements Serializable, Comparable<Ator> {
	private static final long serialVersionUID = 1L;

	public Ator(String nome) {
		this.setNome(nome);
	}

	@Override
	public int compareTo(Ator o) {

		return this.getNome().compareTo(o.getNome());
	}

}
