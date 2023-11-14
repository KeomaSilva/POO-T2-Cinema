package cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("1-cadastrar filme\n "
				+ "1a-cadastrar salas e horarios\n"
				+ "1b- incluir\n"
				+ "1c-excluir\n"
				+ "1d-alterar\n"
				+ "2-pesquisar filme por nome ou numero\n"
				+ "2a-mostra todos os filmes com o nome escrito, permite seleçao, em menu, sobre qual filme, mostrando suas informações"
				+ "2b-filmes em exibição durante um periodo determinado por data inicial e final, ordem decresente de ingressos vendidos"
				+ "3-listar todos os elementos\n"
				+ "4-consultar disponibilidade de ingresso\n"
				+ "4a-por filme\n"
				+ "4b-por dia\n"
				+ "4c-por horario\n"
				+ "E-implementar execao\n"
				+ "E-dados gravados em arquivos\n");
		
		System.out.println(sb);
		Scanner tc = new Scanner(System.in);
		List<Filme> filmes = new ArrayList<>();
		List<Pessoa> pessoas = new ArrayList<>();
		int opcao = tc.nextInt();
			if(opcao==1) {
				for(int i=0; i <10; i++) {
					System.out.println("Cadastro de filme\n\n"
							+ "Informe o nome do filme:");
					String nome =tc.next();
					System.out.println("Informe o ano de lançamento do filme:");
					int ano = tc.nextInt();
					System.out.println("Informe a descrição do filme:");
					String descricao = tc.next();
					System.out.println("Informe a duração do filme:");
					float duracao = tc.nextFloat();
					//talvez tenha genero do filmes, atores e diretor
					System.out.println("Informe o nome do diretor:");
					String nomeD = tc.next();
					pessoas.add(new Pessoa(nome));
					filmes.add(new Filme(nome, ano, descricao, duracao, nomeD));
					
					System.out.println("Quer informar outro filme?\n S - sim\n N - não");
					String op = tc.next();
					if(op.equalsIgnoreCase("s")) {
						i--;
					} else {
						i=10;
					}
				}
			} else if(opcao==2) {
				System.out.println("Informe o filme que está procurando:\n");
				String nomeP = tc.next();
				
				
				for(Filme filme: filmes) {
					//String[] filmeP = filme.splite(" ");
					if(nomeP.equalsIgnoreCase(filme.getNome())) {
						System.out.println(filme.getNome() + ".\n");
						System.out.println(filme.getAno() + ".\n");
						System.out.println(filme.getDescricao() + ".\n");
						System.out.println(filme.getDuracao() + ".\n");
					}
				}		
			}
//			System.out.println(sb);
//			opcao = tc.nextInt();
			
			for(Filme filme: filmes) {
				System.out.println(filme.getNome());
				System.out.println(filme.getNomeD());
			}
			tc.close();
		}
}


	
