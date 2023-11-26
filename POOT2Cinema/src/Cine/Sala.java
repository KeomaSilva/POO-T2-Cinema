package Cine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sala implements Serializable, Comparable<Sala> {
	private static final long serialVersionUID = 1L;

	private String nome;
	private int numero;
	private List<Assento> lugares;

	public Sala(int numero) {
		this.nome = "10" + numero;
		this.numero = numero;
		lugares = new ArrayList<>();

	}

	public String toString() {
		return this.nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int compareTo(Sala o) {
		return this.nome.compareToIgnoreCase(o.nome);
	}

}
