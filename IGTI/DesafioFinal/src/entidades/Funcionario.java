package entidades;

public class Funcionario {
	private String nome;
	private double salarioBruto;

	public Funcionario(String nome, double salarioBruto) {
		this.nome = nome;
		this.salarioBruto = salarioBruto;
	}
	
	//Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	
	
	
}
