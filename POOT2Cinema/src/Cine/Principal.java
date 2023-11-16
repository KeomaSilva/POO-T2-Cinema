package Cine;

public class Principal {
	private Cinema ucs;

	public Principal() {
		Cinema ucs = new Cinema();
	}

	public static void main(String[] args) {
		Principal pr = new Principal();
		pr.menu();
	}

	public void menu() {
		System.out.println("-----------------------");
		System.out.println("Bem Vindo ao Cinema POO");
		System.out.println("1 - Comprar ingresso");
		System.out.println("2 - Listar filmes ativos");
		System.out.println("3 - SubMenu Cadastro");

	}

}
