package br.com.fiap.banco.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Cria conexões com o banco de dados
public class ConnectionFactory {

	//static -> método pertence a classe e não ao objeto
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// Abrir a conexão com o banco
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "usuario","senha");
		return conn;
	}
	
	public static void fecharConexao(Connection con) {
		try {
			con.close();
			//System.out.println("Conex�o fechada");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Erro para fechar");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " Erro para fechar");
		}
	}

}