package Cine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBase {

	private List<Genero> generosDataBase;
	private List<Ator> atoresDataBase;
	private List<Diretor> diretoresDataBase;

	public DataBase() {
		generosDataBase = new ArrayList<>();
		atoresDataBase = new ArrayList<>();
		diretoresDataBase = new ArrayList<>();
	}

	public String adicionarGeneroALista(String nome) {
		StringBuilder str = new StringBuilder();
		boolean possui = false;
		Collections.sort(generosDataBase);
		for (Genero genero : generosDataBase) {
			if (genero.getNome().equalsIgnoreCase(nome)) {
				possui = true;
				str.append("Gênero já presente na lista");
				break;
			}
		}
		if (!possui) {
			generosDataBase.add(new Genero(nome));
			str.append("Gênero adicionado à lista");
		}
		return str.toString();
	}

	public String listarGeneros() {
		StringBuilder str = new StringBuilder();
		Collections.sort(generosDataBase);
		if (generosDataBase == null) {
			str.append("Nenhum gênero cadastrado");
		} else {
			for (int i = 0; i < generosDataBase.size(); i++) {
				String index = "" + (i + 1);
				str.append(index + " - " + generosDataBase.get(i).getNome());
			}
		}
		return str.toString();
	}

	public Genero selecionarGeneroDaLista(int index) {
		Collections.sort(generosDataBase);
		Genero x;
		try {
			x = generosDataBase.get(index);
		} catch (Exception e) {
			x = null;

		}
		return x;
	}

	public List<Genero> getGenerosDataBase() {
		return generosDataBase;
	}

	public List<Ator> getAtoresDataBase() {
		return atoresDataBase;
	}

	public List<Diretor> getDiretoresDataBase() {
		return diretoresDataBase;
	}

}
