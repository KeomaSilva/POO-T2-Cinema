package Cine;

import java.io.Serializable;

public class Ator extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Ator(String nome) {
		this.setNome(nome);		
	}

}
