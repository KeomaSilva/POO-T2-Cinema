package Cine;

import java.io.Serializable;

public class Pessoa implements Serializable{

	private String nome;
	private String paisOrigem;
	private Pessoa casado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public Pessoa getCasado() {
		return casado;
	}

	public void setCasado(Pessoa casado) {
		this.casado = casado;
	}

}
