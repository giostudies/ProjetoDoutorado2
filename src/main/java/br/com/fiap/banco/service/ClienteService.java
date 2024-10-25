package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.dao.ClienteDao;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Cliente;



public class ClienteService {

	private ClienteDao clienteDao;
	
	public ClienteService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		clienteDao = new ClienteDao(conn);

	}
	
	public List<Cliente> listar() throws ClassNotFoundException, SQLException{
		return clienteDao.listar();
	}
	
	
}