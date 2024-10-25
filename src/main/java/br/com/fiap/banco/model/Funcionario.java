package br.com.fiap.banco.model;

public class Funcionario extends Pessoa{
	
	private double salario;

	public Funcionario() {
	}
	
	public Funcionario(double salario) {
		this.salario = salario;
	}
	
	public Funcionario(String nome) {
		super(nome);
	}
	
	public Funcionario(String nome, double salario) {
		super(nome);
		this.salario = salario;
	}
	
	public Funcionario(int codigo, String nome, double salario) {
		super(codigo, nome);
		this.salario = salario;
	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	

	
}
