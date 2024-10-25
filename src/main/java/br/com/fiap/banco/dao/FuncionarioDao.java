package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Funcionario;

public class FuncionarioDao {

	private Connection conn;

	public FuncionarioDao(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Funcionario funcionario) throws ClassNotFoundException, SQLException {

		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn.prepareStatement("INSERT INTO funcionariofinaldois (nome, salario) values (?, ?)");

		// Setar os valores no comando SQL
		//stm.setInt(1, 3);
		stm.setString(1, funcionario.getNome());
		stm.setDouble(2, funcionario.getSalario());

		// Executar o comando SQL
		stm.executeUpdate();
	}

	public List<Funcionario> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from funcionariofinaldois");

		ResultSet result = stm.executeQuery();
		List<Funcionario> lista = new ArrayList<Funcionario>();

		while (result.next()) {
			Funcionario funcionario = parse(result);
			lista.add(funcionario);
			
		}
		///////////////////////////////////////////////////////////////////////////////////////
		conn.close();
		return lista;
		
	}
	
	private Funcionario parse(ResultSet result) throws SQLException {

		int codigo = result.getInt("codigo");
		String nome = result.getString("nome");
		double salario = result.getDouble("salario");

		Funcionario funcionario = new Funcionario(codigo, nome, salario);

		return funcionario;
		
	}
	
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("delete from funcionariofinaldois where codigo = ?");
		// Setar os parametros na Query
		stm.setInt(1, id);
		// Executar a Query
		stm.executeUpdate();
		//int linha = stm.executeUpdate();
		//if (linha == 0) {
		//	throw new IdNotFoundException("Nome não encontrado para remoção");
		//}
		///////////////////////////////////////////////////////////////////////////////////////
		conn.close();
	}

	public void atualizar(Funcionario funcionario) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("update funcionariofinaldois set nome = ?, salario = ? where codigo = ?");
		// Setar os parametros na Query
		stm.setString(1, funcionario.getNome());
		stm.setDouble(2, funcionario.getSalario());
		stm.setInt(3, funcionario.getCodigo());
		
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Não encontrado para atualizar");
	}
	
	
}