package Cine;

import java.io.Serializable;

public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	private int numero;
	private Assento lugares;

	public Sala(int numero) {
		this.numero = numero;
		this.lugares = new Assento(this);

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Assento getLugares() {
		return lugares;
	}

	public void setLugares(Assento lugares) {
		this.lugares = lugares;
	}

}
