package Cine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Horario implements Serializable, Comparable<Horario> {
	private static final long serialVersionUID = 1L;
	private String codigoHorario;
	private String dataString;
	private String horario;
	private Sala sala;
	private List<Ingresso> ingressos;

	public Horario(String data, int opcao, Sala sala) {
		this.dataString = data;
		String dataReplace = data.replace("/", " ");
		String[] dataRepartida = dataReplace.split(" ");
		String dataInvertida = dataRepartida[2] + dataRepartida[1] + dataRepartida[0];
		codigoHorario = dataInvertida + opcao + sala.getNome();
		this.sala = sala;
		ingressos = new ArrayList<>();
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

	public String matrixSala() {
		StringBuilder str = new StringBuilder();
		str.append("-------PROJETOR-------\n");
		for (int i = this.sala.getFileira(); i > 0; i--) {
			str.append("Linha " + (i - 1) + " ");
			for (int j = 0; j < this.sala.getColuna(); j++) {
				if (ingressos != null) {
					int count = 0;
					for (Ingresso ingresso : ingressos) {
						if (ingresso.getAssentoNumero().equalsIgnoreCase((i - 1) + "" + j)) {
							count = 1;
						}
					}
					if (count != 0) {
						str.append("- XX ");
						count = 0;
					} else {
						str.append("- " + (i - 1) + "" + j + " ");

					}

				} else {
					str.append("- " + i + "" + j + " ");
				}

			}
			str.append("\n");
		}
		str.append("---------TELA---------");

		return str.toString();

	}

	public String ingressoComprado(String codigoHorario, int assento, Filme filme, Horario horario, String nome,
			String celular, Sala sala, String meiaEntrada) {
		StringBuilder ingressoCodigo = new StringBuilder();
		ingressoCodigo.append("");
		boolean possui = false;
		if (ingressos == null) {
			ingressos.add(new Ingresso(codigoHorario, assento, filme, horario, nome, celular, sala, meiaEntrada));
			ingressoCodigo.append("Compra do ingresso realizada");
			ingressoCodigo.append("INGRESSO: " + ingressos.get(0));
		} else {
			for (Ingresso ingresso : ingressos) {
				if (ingresso.getAssento().getCodigo() == assento + "") {
					possui = true;
					ingressoCodigo.append("Assento da sala não está vago");
					break;
				}
			}
			if (!possui) {
				ingressos.add(new Ingresso(codigoHorario, assento, filme, horario, nome, celular, sala, meiaEntrada));
				ingressoCodigo.append("Compra do ingresso realizada");
				ingressoCodigo.append(ingressos.get(ingressos.size() - 1));

			}
		}

		return ingressoCodigo.toString();

	}

	public String getCodigoHorario() {
		return codigoHorario;
	}

	public void setCodigoHorario(String codigoHorario) {
		this.codigoHorario = codigoHorario;
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
		return this.codigoHorario.compareTo(o.codigoHorario);
	}

}
