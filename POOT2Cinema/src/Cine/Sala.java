package Cine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sala implements Serializable, Comparable<Sala> {
	private static final long serialVersionUID = 1L;

	private String nome;
	private int numero;
	private int fileira;
	private int coluna;
	private List<Assento> lugares;

	public Sala(int numero, int fileira, int coluna) {
		this.nome = "10" + numero;
		this.numero = numero;
		this.fileira = fileira;
		this.coluna = coluna;
		lugares = new ArrayList<>();
	}

	public String matrixSala() {
		StringBuilder str = new StringBuilder();
		str.append("-------PROJETOR-------");
		for (int i = this.fileira; i >= 0; i--) {
			str.append("Linha " + (i - 1) + " ");
			for (int j = 0; j < this.coluna; j++) {
				if() {
					str.append("- XX ");
				}else {
					str.append("- " + i + "" + j + " ");					
				}
			}
		}
		str.append("---------TELA---------");

		return str.toString();
	}

	public String toString() {
		return this.nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	@Override
	public int compareTo(Sala o) {
		return this.nome.compareToIgnoreCase(o.nome);
	}

}
