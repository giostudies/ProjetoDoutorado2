package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.dao.FuncionarioDao;

import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Funcionario;



public class FuncionarioService {

	private FuncionarioDao funcionarioDao;
	
	public FuncionarioService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		funcionarioDao = new FuncionarioDao(conn);

	}
	
	
	public void cadastrar(Funcionario funcionario) throws ClassNotFoundException, SQLException, BadInfoException {
		funcionarioDao.cadastrar(funcionario);
	}
	
	
	public List<Funcionario> listar() throws ClassNotFoundException, SQLException{
		return funcionarioDao.listar();
	}
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		funcionarioDao.remover(id);
	}

	
	public void atualizar(Funcionario funcionario) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		funcionarioDao.atualizar(funcionario);
	}
}