package Cine;

import java.io.Serializable;

public class Sala implements Serializable {
	
	private String numero;
	private Assento lugares;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Assento getLugares() {
		return lugares;
	}

	public void setLugares(Assento lugares) {
		this.lugares = lugares;
	}

}
