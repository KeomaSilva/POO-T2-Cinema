package Cine;

import java.io.Serializable;

public class Assento implements Serializable, Comparable<Assento> {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private int fileira;
	private int numero;
	private Sala sala;

	public Assento(Sala sala) {
		this.fileira = 10;
		this.numero = 10;
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

	public int getFileira() {
		return fileira;
	}

	public void setFileira(int fileira) {
		this.fileira = fileira;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int compareTo(Assento o) {

		return this.codigo.compareTo(o.codigo);
	}

}
