import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import entidades.Funcionario;

public class Controle {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<Funcionario> funcionarios = new ArrayList<>();
	DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
	
	public void iniciar() {
		String opcao = mostrarMenu();
		while (!opcao.equals("3")) {
			switch (opcao) {
			case "1":
				cadastraFuncionario();
				break;
			case"2":
				imprimeContracheque();
				break;
			default:
				System.out.println("Opção Inválida.");
			}
			opcao = mostrarMenu();
		}
		System.out.println("Programa encerrado.");
	}
	
	public String mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("=========== Menu Principal ==========\n");
		sb.append("1- Cadastrar funcionário \n");
		sb.append("2- Imprimir contracheque \n");
		sb.append("3- Sair \n");
		sb.append("===================================== \n");
		sb.append("Digite a opção desejada: ");
		
		System.out.println(sb.toString());
		return scanner.nextLine();
	}
	
	public void cadastraFuncionario() {
		System.out.println("Digite o nome do funcionario: ");
		String nome = scanner.nextLine();
		System.out.println("Digite o salário bruto do funcionario: ");
		Double salarioBruto = Double.parseDouble(scanner.nextLine());
		Funcionario funcionario = new Funcionario(nome, salarioBruto);
		funcionarios.add(funcionario);
		
	}
	
	public void imprimeContracheque() {
		System.out.println("==== Lista de Funcionários ====");
		mostraIndiceFuncionarios(funcionarios);
		System.out.printf("\n===============================\n");
		System.out.println("Digite o índice do funcionario: ");
		int indiceFuncionario = Integer.parseInt(scanner.nextLine());
		Funcionario funcionario = funcionarios.get(indiceFuncionario);
		double inss = calculaInss(funcionario.getSalarioBruto());
		double irrf = calculaIrrf(funcionario.getSalarioBruto() - inss);
		double salarioLiquido = funcionario.getSalarioBruto() - inss - irrf;
		
		StringBuilder sb = new StringBuilder();
		sb.append("===============================\n");
		sb.append("======== CONTRA CHEQUE ========\n");
		sb.append("===============================\n");
		sb.append("-Funcionário: ");
		sb.append(funcionario.getNome());
		sb.append("\n-Salário Bruto:  ");
		sb.append(decimalFormat.format(funcionario.getSalarioBruto()));
		sb.append("\n-Desconto INSS: ");
		sb.append(decimalFormat.format(inss));
		sb.append("\n-Desconto IRRF: ");
		sb.append(decimalFormat.format(irrf));
		sb.append("\n-Salário Líquido: ");
		sb.append(decimalFormat.format(salarioLiquido));
		
		System.out.println(sb.toString());
	}
	
	private void mostraIndiceFuncionarios(ArrayList<Funcionario> funcionarios) {
		for (var i = 0; i < funcionarios.size(); i++) {
			System.out.printf("%d- %s ", i, funcionarios.get(i).getNome());
		}
	}
	
	private double calculaInss(double salario) {
		double inss = 0;
		if (salario > 6101.06) {
			return 713.10;
		}
		if (salario > 3134.40) {
			inss += (salario - 3134.40) * 0.14;
			salario = 3134.40;
		}
		if (salario > 2089.60) {
			inss += (salario - 2089.60) * 0.12;
			salario = 2089.60;
		}
	    if (salario > 1045.00) {
	    	inss += (salario - 1045.00) * 0.09;
	    	salario = 1045.00;
	    }
	    inss += salario * 0.075;
	    return inss;
	}
	
	private double calculaIrrf(double salarioComDesconto) {
		if (salarioComDesconto < 1903.99) {
			return 0;
		}
	    if (salarioComDesconto < 2826.66) {
	    	return (salarioComDesconto * 0.075) - 142.80;
	    }
	    if (salarioComDesconto < 3751.06) {
	    	return (salarioComDesconto * 0.15) - 354.80;
	    }
	        
	    if (salarioComDesconto < 4664.69) {
	    	return (salarioComDesconto * 0.225) - 636.13;
	    }
	    return (salarioComDesconto * 0.275) - 869.36;
	}
	
}
