package entidades;

public class Cliente extends Pessoa {
	private String endereco;

	public Cliente(String nome, String cpf, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}
	
	public String toString() {
		return "[" + nome + " - CPF: " + cpf + " - End.: " + endereco + "]";
	}
	
	//Getters e Setters
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
