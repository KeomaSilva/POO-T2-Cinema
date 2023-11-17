package Cine;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Assento implements Serializable {

	private static final long serialVersionUID = 1L;
	private int fileira;
	private int coluna;
	private Sala sala;
	private Map<String, Ingresso> ingressos;

	public Assento(Sala sala) {
		this.fileira = 10;
		this.coluna = 10;
		this.sala = sala;
		ingressos = new HashMap<>();
	}

	public String lugaresVagos() {
		StringBuilder str = new StringBuilder();
		str.append("");
		for (int i = 11; i >= 1; i--) {
			if(i == 11) {
				str.append("Linhas  - ");
			}else {
				str.append("Linha " + "i" + " - ");				
			}
			for (int j = 0; j <= 10;) {
				if(j==0) {
					str.append("- O -");
				}
				if() {
					str.append("- O -");
				} else {
					str.append("- X -");
				}
			}
		}
		str.append("\n----- TELA -----");
		return str.toString();
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
