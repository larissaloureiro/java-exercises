package pizzaria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaPedidos {
	private Scanner scanner = new Scanner(System.in);
	private Queue<String> filaPedidos  =  new LinkedList<>();
	
	public void iniciar() {
		String opcao = mostrarMenu();
		
		while(!opcao.equals("4")) {
			switch (opcao) {
			case "1":
				System.out.println("Digite o nome da pessoa para adicionar na fila: ");
				ArrayList<String> pedidos = new ArrayList<String>(Arrays.asList(scanner.nextLine().split(",")));
				filaPedidos.addAll(pedidos);
				break;
			case "2":
				if (filaPedidos.isEmpty()) {
					System.out.println("----- A fila de pedidos está vazia. -----");
					break;
				}
				System.out.printf("----- Próximo pedido: %s -----%n", filaPedidos.remove());
				break;
			case "3":
				System.out.println(filaPedidos);
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
		sb.append("1- Inserir cliente na fila \n");
		sb.append("2- Próximo cliente \n");
		sb.append("3- Verificar fila de pedidos \n");
		sb.append("4- Sair \n");
		System.out.println(sb.toString());
		return scanner.nextLine();
	}
}
