package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.banco.dao.UsuarioDao;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Usuario;



public class UsuarioService {

	private UsuarioDao usuarioDao;
	
	public UsuarioService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		usuarioDao = new UsuarioDao(conn);

	}
	
	
	public void cadastrar(Usuario usuario) throws ClassNotFoundException, SQLException, BadInfoException {
		//validar(funcionario);
		usuarioDao.cadastrar(usuario);
	}
	
	
	public List<Usuario> listar() throws ClassNotFoundException, SQLException{
		return usuarioDao.listar();
	}
	
	public void remover(String nome) throws ClassNotFoundException, SQLException, IdNotFoundException {
		usuarioDao.remover(nome);
	}

	
	public void atualizar(Usuario usuario) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		//validar(produto);
		usuarioDao.atualizar(usuario);
	}
}