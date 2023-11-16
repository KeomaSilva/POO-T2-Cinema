package Cine;

import java.io.Serializable;

public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String numero;
	private Assento lugares;
	
	public Sala(String numero) {
		this.numero = numero;
		
	}

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
