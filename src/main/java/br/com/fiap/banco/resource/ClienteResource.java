package br.com.fiap.banco.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.model.Cliente;
import br.com.fiap.banco.service.ClienteService;

import jakarta.ws.rs.GET;

import jakarta.ws.rs.Path;

import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.MediaType;



@Path("/cliente") 
public class ClienteResource {

	private ClienteService service;
	
	public ClienteResource() throws ClassNotFoundException, SQLException {
		service = new ClienteService();
	}
	
	//GET http://localhost:8080/07-WebApi/api/produto (Listar todos os produtos)
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Cliente> lista() throws ClassNotFoundException, SQLException {
			return service.listar();
		}
	
	
	
}
