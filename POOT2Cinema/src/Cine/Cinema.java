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
		str.append("------------------");
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
		String res = "Filme não encontrado no banco de dados";
		for (Filme filme : filmes) {
			if (filme.equals(removeFilme)) {
				filmes.remove(filme);
				res = "Filme removido do catalago";
			}
		}

		return res;
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
		try{
			for (int i = 0; i<filmes.size();i++) {
				if ((i-1) == index) {
					x = filmes.get(i - 1);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public String alterarDadosFilme(Filme filme) {
		StringBuilder str = new StringBuilder();
		if(filme!=null){
			str.append("O filme selecionado foi: "+filme.getNome());
		}else {
			str.append("Não foi possível selecionar nenhum filme");
		}
		
		return str.toString();
	}

	public String filmesCatalago() {
		StringBuilder str = new StringBuilder();
		ordenarFilmes();
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
			str.append("Sala: " + sala.getNumero() + " - ");
		}
		str.append("há um total de: " + salas.size() + " salas");
		return str.toString();
	}

	private void ordenarFilmes() {
		Collections.sort(filmes);
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
