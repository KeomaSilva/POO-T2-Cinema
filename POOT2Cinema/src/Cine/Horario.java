package Cine;

import java.io.Serializable;

public class Horario implements Serializable, Comparable<Horario> {
	private static final long serialVersionUID = 1L;
	private String data;
	private String horario;
	private Sala sala;

	public Horario(String data, String horario, Sala sala) {
		this.data = data;
		this.horario = horario;
		this.sala = sala;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.data + " - ");
		str.append(this.horario + " - ");
		str.append(this.sala + " - ");
		str.append("\n");
		return str.toString();
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Override
	public int compareTo(Horario o) {
		return this.data.compareToIgnoreCase(o.data);
	}

}
