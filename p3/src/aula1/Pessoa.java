package aula1;

public class Pessoa {
	private String nome;
	private int cc;
	private Data dataNasc;
	
	public Pessoa (String input_nome, int input_cc, Data input_data) {
		assert input_nome.length() != 0;
		assert input_data != null;
		
		this.nome = input_nome;
		this.cc = input_cc;
		this.dataNasc = input_data;
	}
	
	public String toString() {
		return "Nome: " + this.nome + "\nCC: " + this.cc + "\nData de nascimento: " + this.dataNasc.toString();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getCC() {
		return this.cc;
	}
}
