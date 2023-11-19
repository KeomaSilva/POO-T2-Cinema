package Cine;

import java.io.Serializable;

public class Ingresso implements Serializable{
	private static final long serialVersionUID = 1L;

	private String nomeComprador;
	private String data;
	private String celular;
	private String preco;
	private String meiaEntrada;
	private Assento assento;
	private Filme filme;
	private Horario horario;

	public String getNomeComprador() {
		return nomeComprador;
	}

	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getMeiaEntrada() {
		return meiaEntrada;
	}

	public void setMeiaEntrada(String meiaEntrada) {
		this.meiaEntrada = meiaEntrada;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

}