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
	private DataBase database;

	public Cinema() {
		salas = new ArrayList<>();
		filmes = new ArrayList<>();
		database = new DataBase();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Nome: " + this.nome);
		str.append("\nEndereço: " + this.endereco);
		str.append("\nQuantidades de filmes em cartaz: " + this.filmes.size());
		str.append("\nQuantidade de salas: " + this.salas.size());
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
		Collections.sort(filmes);
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
		Collections.sort(salas);
		int count = 0;
		try {
			if (salas.size() == 0) {
				this.salas.add(new Sala(1));
			} else {
				for (int i = 0; i < salas.size(); i++) {
					if (salas.get(i).getNumero() == i + 1) {
						count++;
					}
					if (count == i) {
						this.salas.add(new Sala(i + 1));
						break;
					}
					if (count == salas.size()) {
						this.salas.add(new Sala(count + 1));
						break;
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getSalas() {
		StringBuilder str = new StringBuilder();
		Collections.sort(salas);
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
		Collections.sort(salas);
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

	public DataBase getDatabase() {
		return database;
	}

}
