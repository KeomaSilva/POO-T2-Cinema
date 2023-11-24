package Cine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cinema implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String endereco;
	private List<Filme> filmes;
	private List<Sala> salas;

	public Cinema() {
		salas = new ArrayList<>();
		filmes = new ArrayList<>();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Nome: " + this.nome);
		str.append(" - Endereço: " + this.endereco);
		str.append(" - Quantidades de filmes em cartaz: " + this.filmes.size());
		str.append(" - Quantidade de salas: " + this.salas.size());
		return str.toString();
	}

	public String addFilme(String nome) {
		String res = "";
		boolean possui = false;

		for (Filme filme : filmes) {
			if (filme.getNome().equalsIgnoreCase(nome)) {
				possui = true;
				break;
			}
		}
		try {
			if (possui) {
				res = "Filme já presente no catálago";

			} else {
				this.filmes.add(new Filme(nome));
				res = "Filme adicionado ao catálago";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public String removeFilme(Filme removeFilme) {

		filmes.remove(removeFilme);
		return "Filme removido do catalago";

	}

	public String getFilmes() {
		StringBuilder str = new StringBuilder();
		for (Filme filme : filmes) {
			str.append(filme.getNome());
		}
		str.append("Total de " + filmes.size() + " cadastrados");
		return str.toString();
	}

	public Filme selecionarFilme(int index) {
		Filme x = null;
		Collections.sort(filmes);
		try {
			for (int i = 0; i < filmes.size(); i++) {
				if (i == index - 1) {
					x = filmes.get(i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public String filmesCatalago() {
		StringBuilder str = new StringBuilder();
		Collections.sort(filmes);
		if (filmes.size() > 0) {
			for (int i = 0; i < filmes.size(); i++) {
				String index = "" + (i + 1);
				str.append(index + " - " + filmes.get(i).getNome());
				str.append("\n");
			}
		} else {
			str.append("Nenhum filme em cartaz.");
		}
		return str.toString();

	}

	public void addSala() {
		int index = this.salas.size();
		this.salas.add(new Sala(index + 1));
	}

	public String getSalas() {
		StringBuilder str = new StringBuilder();
		for (Sala sala : salas) {
			str.append("Sala: " + sala.getNome() + " - ");
		}
		str.append("há um total de: " + salas.size() + " salas");
		return str.toString();
	}

	public String listarSalas() {
		StringBuilder str = new StringBuilder();
		Collections.sort(salas);
		for (int i = 0; i < salas.size(); i++) {
			String index = "" + (i + 1);
			str.append(index + " - Sala: " + salas.get(i));
			str.append("\n");
		}
		return str.toString();
	}
	public String removeSala(Sala sala) {
		salas.remove(sala);
		return "Sala removida com sucesso";
		
	}

	public Sala selecionarSala(int index) {
		Sala x = null;
		Collections.sort(salas);
		try {
			for (int i = 0; i < salas.size(); i++) {
				if (i == index - 1) {
					x = salas.get(i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
