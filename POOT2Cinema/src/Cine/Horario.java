package Cine;

import java.io.Serializable;

public class Horario implements Serializable, Comparable<Horario> {
	private static final long serialVersionUID = 1L;
	private String dataString;
	private String dataInvertida;
	private String horario;
	private Sala sala;

	public Horario(String data, int opcao, Sala sala) {
		this.dataString = data;
		String dataReplace = data.replace("/", " ");
		String[] dataRepartida = dataReplace.split(" ");
		this.dataInvertida = dataRepartida[2]+dataRepartida[1]+dataRepartida[0];
		this.sala = sala;
		if (opcao == 1) {
			this.horario = "15:00";
		}
		if (opcao == 2) {
			this.horario = "18:00";
		}
		if (opcao == 3) {
			this.horario = "21:00";
		}
		System.out.println(dataInvertida);
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.dataString + " - ");
		str.append(this.horario + " - ");
		str.append(this.sala + " - ");
		return str.toString();
	}

	public String getDataInvertida() {
		return dataInvertida;
	}

	public void setDataInvertida(String dataInvertida) {
		this.dataInvertida = dataInvertida;
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
		return this.dataInvertida.compareTo(o.dataInvertida);
	}

}
