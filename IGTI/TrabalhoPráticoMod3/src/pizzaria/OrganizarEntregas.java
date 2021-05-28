package pizzaria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class OrganizarEntregas {
	private Scanner scanner = new Scanner(System.in);
	private Stack<Integer> entregas =  new Stack<>();
	
	public void iniciar() {
		String opcao = mostrarMenu();
		
		while(!opcao.equals("3")) {
			switch (opcao) {
			case "1":
				System.out.println("Digite as distâncias separadas por vírgulas(Ex: 2,6,4): ");
				ArrayList<String> entrada = new ArrayList<String>(Arrays.asList(scanner.nextLine().split(",")));
				ArrayList<Integer> distancias = new ArrayList<Integer>();
				for (int i = 0; i < entrada.size(); i++) {
					distancias.add(Integer.valueOf(entrada.get(i)));
				}
				Collections.sort(distancias, Collections.reverseOrder());
				while (distancias.size() > 0) {
					entregas.add(distancias.remove(0));
				}
				
				break;
			case "2":
				if (entregas.isEmpty()) {
					System.out.println("----- A pilha de pedidos está vazia. -----");
					break;
				}
				System.out.printf("----- Pedido removido: %s. -----%n", entregas.pop());
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
		sb.append("1- Organizar Entregas \n");
		sb.append("2- Desempilhar pedido \n");
		sb.append("3- Sair \n");
		System.out.println(sb.toString());
		return scanner.nextLine();
	}
}
