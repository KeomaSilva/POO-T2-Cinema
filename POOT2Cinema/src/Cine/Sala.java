package Cine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	private int numero;
	private List<Assento> lugares;

	public Sala(int numero) {
		this.numero = numero;
		lugares = new ArrayList<>();

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
