package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.banco.model.Cliente;


public class ClienteDao {
	
	private Connection conn;
	
	public ClienteDao(Connection conn) {
		this.conn = conn;
	}
	
	public List<Cliente> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from CLIENTE");

		ResultSet result = stm.executeQuery();
		List<Cliente> lista = new ArrayList<Cliente>();


		while (result.next()) {
			Cliente cliente = parse(result);
			lista.add(cliente);
		}
		
		return lista;
	}


	private Cliente parse(ResultSet result) throws SQLException {
		
		String nome = result.getString("nome");
		double limiteCredito = result.getDouble("limiteCredito");
		
		Cliente cliente = new Cliente(nome, limiteCredito);
		
		
		return cliente;
	}
}