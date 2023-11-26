package Cine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBase implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Genero> generosDataBase;
	private List<Ator> atoresDataBase;
	private List<Diretor> diretoresDataBase;

	public String toString() {
		return "ela EXISTE";
	}

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
				str.append(index + ": " + generosDataBase.get(i).getNome() + "  - ");
			}
		}
		return str.toString();
	}

	public Genero selecionarGeneroDaLista(int index) {
		Collections.sort(generosDataBase);
		Genero x;
		try {
			x = generosDataBase.get(index - 1);
		} catch (Exception e) {
			System.out.println("retornou genero null");
			x = null;

		}
		return x;
	}
	public String removeGenerosBanco(int index) {
		StringBuilder str = new StringBuilder();
		try {
			Collections.sort(generosDataBase);
			generosDataBase.remove(index - 1);
			str.append("Gênero removido do danco de dados");

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return str.toString();
	}

	public String adicionarAtoresALista(String nome) {
		StringBuilder str = new StringBuilder();
		boolean possui = false;
		Collections.sort(atoresDataBase);
		for (Ator ator : atoresDataBase) {
			if (ator.getNome().equalsIgnoreCase(nome)) {
				possui = true;
				str.append("Ator já presente na lista");
				break;
			}

		}
		if (!possui) {
			atoresDataBase.add(new Ator(nome));
			str.append("Ator adicionado à lista");
		}

		return str.toString();

	}

	public String listarAtores() {
		StringBuilder str = new StringBuilder();
		Collections.sort(atoresDataBase);
		if (atoresDataBase == null) {
			str.append("Nenhum ator cadastrado");
		} else {
			for (int i = 0; i < atoresDataBase.size(); i++) {
				String index = "" + (i + 1);
				str.append(index + ": " + atoresDataBase.get(i).getNome() + "  - ");
			}
		}

		return str.toString();

	}

	public Ator selecionarAtoresDaLista(int index) {
		Collections.sort(atoresDataBase);
		Ator x;
		try {
			x = atoresDataBase.get(index - 1);
		} catch (Exception e) {
			System.out.println("retornou ator null");
			x = null;

		}
		return x;

	}
	
	public String removeAtoresBanco(int index) {
		StringBuilder str = new StringBuilder();
		try {
			Collections.sort(atoresDataBase);
			atoresDataBase.remove(index - 1);
			str.append("Ator removido do danco de dados");

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return str.toString();
	}

	public String adicionarDiretorALista(String nome) {
		StringBuilder str = new StringBuilder();
		boolean possui = false;
		Collections.sort(diretoresDataBase);
		for (Diretor diretor : diretoresDataBase) {
			if (diretor.getNome().equalsIgnoreCase(nome)) {
				possui = true;
				str.append("Diretor já presente na lista");
				break;
			}

		}
		if (!possui) {
			diretoresDataBase.add(new Diretor(nome));
			str.append("Diretor adicionado à lista");
		}

		return str.toString();

	}

	public String listarDiretores() {
		StringBuilder str = new StringBuilder();
		Collections.sort(diretoresDataBase);
		if (diretoresDataBase == null) {
			str.append("Nenhum diretor cadastrado");
		} else {
			for (int i = 0; i < diretoresDataBase.size(); i++) {
				String index = "" + (i + 1);
				str.append(index + ": " + diretoresDataBase.get(i).getNome() + "  - ");
			}
		}

		return str.toString();
	}

	public Diretor selecionarDiretorDaLista(int index) {
		Collections.sort(diretoresDataBase);
		Diretor x;
		try {
			x = diretoresDataBase.get(index - 1);
		} catch (Exception e) {
			System.out.println("retornou diretor null");
			x = null;

		}
		return x;

	}
	public String removeDiretorBanco(int index) {
		StringBuilder str = new StringBuilder();
		try {
			Collections.sort(diretoresDataBase);
			diretoresDataBase.remove(index - 1);
			str.append("Diretor removido do danco de dados");

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return str.toString();
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
