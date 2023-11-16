package Cine;

import java.io.Serializable;

public class Assento implements Serializable {

	private static final long serialVersionUID = 1L;
	private int fileira;
	private int numero;
	private Sala sala;
	

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

}
