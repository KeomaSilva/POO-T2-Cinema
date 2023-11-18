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
		str.append("----- FUNDO -----\n");
		for (int i = 9; i >= 0; i--) {
			str.append("Linha " + i + ":");
			for (int j = 1; j <= 10;) {
				if (j < 10) {
					String codigo = i + "" + j;
					if (this.ingressos.containsKey(codigo)) {
						str.append("- X -");
					} else {
						str.append("- " + i + "" + j);
					}
				} else {
					String codigo = i + 1 + "" + j;
					if (this.ingressos.containsKey(codigo)) {
						str.append("- X -");
					} else {
						str.append("- " + i + 1 + "0 -");
					}
				}
			}
			str.append("\n");
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
