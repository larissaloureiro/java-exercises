package pizzaria;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ListaContatos listaContatos = new ListaContatos();
		FilaPedidos filaPedidos = new FilaPedidos();
		OrganizarEntregas organizarEntregas = new OrganizarEntregas();
		
		String opcao = mostrarMenu();
		
		while(!opcao.equals("4")) {
			switch (opcao) {
			case "1":
				listaContatos.iniciar();
				break;
			case "2":
				filaPedidos.iniciar();
				break;
			case "3":
				organizarEntregas.iniciar();
				break;
			default:
				System.out.println("Opção inválida.");
			}
			opcao = mostrarMenu();
		}
		System.out.println("Programa encerrado.");
	}
	
	static public String mostrarMenu() {
		Scanner scanner = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		sb.append("Digite a função desejada: \n");
		sb.append("1- Lista de Contatos \n");
		sb.append("2- Fila de Pedidos \n");
		sb.append("3- Organizar Entregas do Motoboy \n");
		sb.append("4- Sair \n");
		
		System.out.println(sb.toString());
		return scanner.nextLine();
	}

}
