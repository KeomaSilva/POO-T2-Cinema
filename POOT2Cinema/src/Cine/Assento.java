package Cine;

import java.io.Serializable;

public class Assento implements Serializable {

	private static final long serialVersionUID = 1L;
	private int fileira;
	private int coluna;
	private Sala sala;

	public Assento (Sala sala) {
		this.fileira = 10;
		this.coluna = 10;
		this.sala = sala;
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

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

}
