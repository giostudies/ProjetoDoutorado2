package br.com.fiap.banco.model;

public class Cliente extends Pessoa{
	
	private double limiteCredito;
	
	public Cliente(String nome, double limiteCredito) {
		super(nome);
		this.limiteCredito = limiteCredito;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

}
