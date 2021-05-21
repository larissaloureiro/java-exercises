import java.util.ArrayList;
import java.util.Scanner;

import entidades.Carro;
import entidades.Cliente;
import entidades.Moto;
import entidades.Vendedor;

public class Controle {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<Carro> carros = new ArrayList<>();
	private ArrayList<Moto> motos = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Vendedor> vendedores = new ArrayList<>();
	
	
	private String mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("Digite o comando desejado: \n");
		sb.append("1- Consultar Carros \n");
		sb.append("2- Consultar Motos \n");
		sb.append("3- Consultar Clientes \n");
		sb.append("4- Consultar Vendedores \n");
		sb.append("5- Cadastrar Carro \n");
		sb.append("6- Cadastrar Moto \n");
		sb.append("7- Cadastrar Cliente \n");
		sb.append("8- Cadastrar Vendedor \n");
		sb.append("9- Vender Carro \n");
		sb.append("10- Vender Moto \n");
		sb.append("0- Sair \n");
		
		System.out.println(sb.toString());
		return scanner.nextLine();
	}
	
	private void mostraIndices(ArrayList<?> lista) {
		for (var i = 0; i < lista.size(); i++) {
			System.out.println("Índice " + i + ": " + lista.get(i));
		}
	}
	
	
	public void iniciar() {
		String opcao = mostrarMenu();
		while (!opcao.equals("0")) {
			switch (opcao) {
			case "1":
				System.out.println(carros);
				break;
			case "2":
				System.out.println(motos);
				break;
			case "3":
				System.out.println(clientes);
				break;
			case "4":
				System.out.println(vendedores);
				break;
			case "5":
				System.out.println("Digite o modelo do carro: ");
				String modeloCarro = scanner.nextLine();
				System.out.println("Digite a marca do carro: ");
				String marcaCarro = scanner.nextLine();
				System.out.println("Digite o ano do carro: ");
				Integer anoCarro = Integer.parseInt(scanner.nextLine());
				System.out.println("Digite o valor do carro: ");
				Double valorCarro = Double.parseDouble(scanner.nextLine());
				mostraIndices(vendedores);
				System.out.println("Digite o índice do vendedor responsável pelo carro: ");
				int indiceVendedorCarro = Integer.parseInt(scanner.nextLine());
				
				Carro carro = new Carro(modeloCarro, marcaCarro, anoCarro, valorCarro, vendedores.get(indiceVendedorCarro));
				carros.add(carro);
				break;
			case "6":
				System.out.println("Digite o modelo da moto: ");
				String modeloMoto = scanner.nextLine();
				System.out.println("Digite a marca da moto: ");
				String marcaMoto = scanner.nextLine();
				System.out.println("Digite o ano da moto: ");
				Integer anoMoto = Integer.parseInt(scanner.nextLine());
				System.out.println("Digite o valor da moto: ");
				Double valorMoto = Double.parseDouble(scanner.nextLine());
				mostraIndices(vendedores);
				System.out.println("Digite o índice do vendedor responsável pela moto: ");
				int indiceVendedorMoto = Integer.parseInt(scanner.nextLine());
				
				Moto moto = new Moto(modeloMoto, marcaMoto, anoMoto, valorMoto, vendedores.get(indiceVendedorMoto));
				motos.add(moto);
				break;
			case "7":
				System.out.println("Digite o nome do cliente: ");
				String nomeCliente = scanner.nextLine();
				System.out.println("Digite o CPF do cliente: ");
				String cpfCliente = scanner.nextLine();
				System.out.println("Digite o endereço do cliente: ");
				String enderecoCliente = scanner.nextLine();
				
				Cliente cliente = new Cliente(nomeCliente, cpfCliente, enderecoCliente);
				clientes.add(cliente);
				break;
			case "8":
				System.out.println("Digite o nome do vendedor: ");
				String nomeVendedor = scanner.nextLine();
				System.out.println("Digite o CPF do vendedor: ");
				String cpfVendedor = scanner.nextLine();
				System.out.println("Digite a matrícula do vendedor: ");
				Integer matriculaVendedor = Integer.parseInt(scanner.nextLine());
				
				Vendedor vendedor = new Vendedor(nomeVendedor, cpfVendedor, matriculaVendedor);
				vendedores.add(vendedor);
				break;
			case "9":
				mostraIndices(carros);
				System.out.println("Digite o índice do carro a ser vendido: ");
				int indiceCarroVendido = Integer.parseInt(scanner.nextLine());
				mostraIndices(clientes);
				System.out.println("Digite o índice do cliente que está comprando: ");
				int indiceClienteCarro = Integer.parseInt(scanner.nextLine());
				
				carros.get(indiceCarroVendido).setCliente(clientes.get(indiceClienteCarro));
				break;
			case "10":
				mostraIndices(motos);
				System.out.println("Digite o índice da moto a ser vendido: ");
				int indiceMotoVendida = Integer.parseInt(scanner.nextLine());
				mostraIndices(clientes);
				System.out.println("Digite o índice do cliente que está comprando: ");
				int indiceClienteMoto = Integer.parseInt(scanner.nextLine());
				
				motos.get(indiceMotoVendida).setCliente(clientes.get(indiceClienteMoto));
				break;
			default:
				System.out.println("Opção Inválida.");
			}
			opcao = mostrarMenu();
		}
		System.out.println("Programa encerrado.");
	}
}
