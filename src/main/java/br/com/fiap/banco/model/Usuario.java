package br.com.fiap.banco.model;

public class Usuario extends Pessoa{
	
	
	private String posicao;

	
	
	public Usuario(String nome, String posicao) {
		super(nome);
		this.posicao = posicao;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
}