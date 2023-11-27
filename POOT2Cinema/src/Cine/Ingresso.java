package Cine;

import java.io.Serializable;

public class Ingresso implements Serializable, Comparable<Ingresso> {
	private static final long serialVersionUID = 1L;

	private String codigoIngresso;
	private String assentoNumero;
	private String nomeComprador;
	private String data;
	private String celular;
	private String preco;
	private String meiaEntrada;
	private Assento assento;
	private Filme filme;
	private Horario horario;

	public Ingresso(String codigoHorario, int assento, Filme filme, Horario horario, String nome, String celular,
			Sala sala, String meiaEntrada) {
		codigoIngresso = codigoHorario + assento;
		this.filme = filme;
		this.horario = horario;
		nomeComprador = nome;
		this.celular = celular;
		this.meiaEntrada = meiaEntrada;
		assentoNumero = "" + assento;
		this.assento = new Assento(assento, sala);

	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Filme: " + filme);
		str.append("Horário: " + horario);
		str.append("Nome: " + nomeComprador);
		str.append("Contato: (54) " + celular);
		return str.toString();
	}

	public String getCodigoIngresso() {
		return codigoIngresso;
	}

	public void setCodigoIngresso(String codigoIngresso) {
		this.codigoIngresso = codigoIngresso;
	}

	public String getAssentoNumero() {
		return assentoNumero;
	}

	public void setAssentoNumero(String assentoNumero) {
		this.assentoNumero = assentoNumero;
	}

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

	@Override
	public int compareTo(Ingresso o) {
		return codigoIngresso.compareTo(o.codigoIngresso);
	}

}
