package cinema;

public class Ingresso {
	private String nomeComprador;
	private String data;
	private int celular;
	private float preco;
	private boolean meiaEntrada;
	
	public Ingresso() {
		
	}

	public String getNomeComprador() {
		return nomeComprador;
	}

	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isMeiaEntrada() {
		return meiaEntrada;
	}

	public void setMeiaEntrada(boolean meiaEntrada) {
		this.meiaEntrada = meiaEntrada;
	}
	
	

}
