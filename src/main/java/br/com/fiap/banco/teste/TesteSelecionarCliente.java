package br.com.fiap.banco.teste;

import java.util.List;

import br.com.fiap.banco.model.Cliente;
import br.com.fiap.banco.service.ClienteService;

public class TesteSelecionarCliente {

	public static void main(String[] args) {
		try {
			ClienteService service = new ClienteService();
			
			List<Cliente> lista = service.listar();
			
			for (Cliente item : lista)
				System.out.println(item.getNome());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}