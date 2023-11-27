package Cine;

import java.io.Serializable;
import java.util.Date;

public class Horario implements Serializable, Comparable<Horario> {
	private static final long serialVersionUID = 1L;
	private String dataString;
	private String horario;
	private Sala sala;
	private Date dataInicio;

	public Horario(String data, int opcao, Sala sala) {
		this.dataString = data;
		int dataInt = Integer.parseInt(data);
		this.sala = sala;
		this.dataInicio = new java.util.Date(data);
		if (opcao == 1) {
			this.horario = "15:00";
		}
		if (opcao == 2) {
			this.horario = "18:00";
		}
		if (opcao == 3) {
			this.horario = "21:00";
		}
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.dataString + " - ");
		str.append(this.horario + " - ");
		str.append(this.sala + " - ");
		return str.toString();
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataString() {
		return dataString;
	}

	public void setDataString(String data) {
		this.dataString = data;
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
		return this.dataString.compareTo(o.dataString);
	}

}
