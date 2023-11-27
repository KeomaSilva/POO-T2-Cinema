package Cine;

import java.io.Serializable;

public class Assento implements Serializable, Comparable<Assento> {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private Sala sala;

	public Assento(int codigo, Sala sala) {
		this.codigo = "" + codigo;
		this.sala = sala;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Override
	public int compareTo(Assento o) {

		return this.codigo.compareTo(o.codigo);
	}

}
