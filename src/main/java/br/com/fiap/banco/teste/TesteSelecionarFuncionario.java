package br.com.fiap.banco.teste;

import java.util.List;

import br.com.fiap.banco.model.Funcionario;
import br.com.fiap.banco.service.FuncionarioService;

public class TesteSelecionarFuncionario {

	//Testar a pesquisa por nome
	public static void main(String[] args) {
		try {
			FuncionarioService service = new FuncionarioService();
			
			//Pesquisar os produtos por nome
			List<Funcionario> lista = service.listar();
			
			//Exibir todos os nomes dos produtos retornados
			for (Funcionario item : lista)
				System.out.println(item.getNome());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}