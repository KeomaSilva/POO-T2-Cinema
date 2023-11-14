package cinema;

public class Pessoa {
	private String nome;
	private int idade;
	private String paisOrigem;
	
	public String toString() {
		return this.nome;
	}
	
	public Pessoa() {
	
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public Pessoa(String nome, int idade, String paisOrigem) {
		this.nome = nome;
		this.idade = idade;
		this.paisOrigem = paisOrigem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}
	
	

}
