package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Usuario;

public class UsuarioDao {

	private Connection conn;

	public UsuarioDao(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Usuario usuario) throws ClassNotFoundException, SQLException {

		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn.prepareStatement("INSERT INTO usuario (nome, posicao) values (?, ?)");

		// Setar os valores no comando SQL
		stm.setString(1, usuario.getNome());
		stm.setString(2, usuario.getPosicao());

		// Executar o comando SQL
		stm.executeUpdate();
	}

	public List<Usuario> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from usuario");

		ResultSet result = stm.executeQuery();
		List<Usuario> lista = new ArrayList<Usuario>();

		while (result.next()) {
			Usuario usuario = parse(result);
			lista.add(usuario);
		}

		return lista;
	}

	private Usuario parse(ResultSet result) throws SQLException {

		String nome = result.getString("nome");
		String posicao = result.getString("posicao");

		Usuario usuario = new Usuario(nome, posicao);

		return usuario;
	}
	
	
	public void remover(String nome) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("delete from usuario where nome = ?");
		// Setar os parametros na Query
		stm.setString(1, nome);
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Nome não encontrado para remoção");
	}

	public void atualizar(Usuario usuario) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("update usuario set posicao = ? where nome = ?");
		// Setar os parametros na Query
		stm.setString(1, usuario.getPosicao());
		//stm.setDouble(1, 700);
		stm.setString(2, usuario.getNome());
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Nome não encontrado para atualizar");
	}
}