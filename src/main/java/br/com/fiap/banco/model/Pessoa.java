package br.com.fiap.banco.model;

public class Pessoa {
	
	private int codigo;
	private String nome;
	
	public Pessoa () {
	}
	
	public Pessoa (String nome) {
		this.nome = nome;
	}
	
	public Pessoa (int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
