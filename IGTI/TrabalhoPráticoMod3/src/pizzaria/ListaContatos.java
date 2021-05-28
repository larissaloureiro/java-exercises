package pizzaria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ListaContatos {
	private ArrayList<String> listaContatos = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
			
	public void iniciar() {
		
		String opcao = mostrarMenu();
		
		while(!opcao.equals("4")) {
			switch (opcao) {
			case "1":
				System.out.println("Digite os contatos que deseja adicionar separados por virgulas:");
				ArrayList<String> contatos = new ArrayList<String>(Arrays.asList(scanner.nextLine().split(",")));
				listaContatos.addAll(contatos);
				break;
			case "2":
				for (int i = 0; i < listaContatos.size(); i++) {
					System.out.printf("Índice %d: %s\n", i, listaContatos.get(i));
				}
				System.out.println("Digite o indice do contato a ser removido:");
				int indice = Integer.valueOf(scanner.nextLine());
				listaContatos.remove(indice);
				break;
			case "3":
				System.out.println(listaContatos);
				break;
			default:
				System.out.println("Opção inválida.");
			}
			opcao = mostrarMenu();
		}
	}
	
	private String mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("Digite o comando desejado: \n");
		sb.append("1- Inserir contato \n");
		sb.append("2- Remover contato \n");
		sb.append("3- Consultar lista de contatos \n");
		sb.append("4- Sair \n");
		System.out.println(sb.toString());
		return scanner.nextLine();
	}
}
