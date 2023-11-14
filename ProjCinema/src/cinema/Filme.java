package cinema;

public class Filme {
	private String nome;
	private int ano;
	private String descricao;
	private float duracao;
	private Pessoa nomeD;
	
	public Filme() {
		
	}
	
	public Filme(String nome) {
		this.nome = nome;
	}
	
	public Filme(String nome, int ano, String descricao, float duracao, String nomeD) {
		this.nome = nome;
		this.ano = ano;
		this.descricao = descricao;
		this.duracao = duracao;
		this.nomeD = new Pessoa(nomeD);
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getDuracao() {
		return duracao;
	}
	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}

	public Pessoa getNomeD() {
		return nomeD;
	}

	public void setNomeD(Pessoa nomeD) {
		this.nomeD = nomeD;
	}
	
	

}
