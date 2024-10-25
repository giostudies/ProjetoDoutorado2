package br.com.fiap.banco.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Funcionario;
import br.com.fiap.banco.service.FuncionarioService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/funcionario") // http://localhost:8080/07-WebApi/api/funcionario
public class FuncionarioResource {

	private FuncionarioService service;

	public FuncionarioResource() throws ClassNotFoundException, SQLException {
		service = new FuncionarioService();
	}

	// POST http://localhost:8080/07-WebApi/api/funcionario/ (Cadastrar um
	// funcionario)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Funcionario funcionario, @Context UriInfo uri)
			throws ClassNotFoundException, SQLException {
		try {
			service.cadastrar(funcionario);
			// Recupera o path (URL atual(http://localhost:8080/07-WebApi/api/funcionario/))
			UriBuilder uriBuilder = uri.getAbsolutePathBuilder();
			// Adiciona o nome do funcionario que foi criado na URL
			// uriBuilder.path(String.valueOf(funcionario.getNome()));
			uriBuilder.path((funcionario.getNome()));
			// Retornar o status 201 com a URL para acessar o funcionario criado
			return Response.created(uriBuilder.build()).build();
		} catch (BadInfoException e) {
			e.printStackTrace();
			// Retornar o status 400 bad request
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	// GET http://localhost:8080/07-WebApi/api/funcionario (Listar todos os
	// funcionarios)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Funcionario> lista() throws ClassNotFoundException, SQLException {
		return service.listar();
	}

	// DELETE http://localhost:8080/07-WebApi/api/funcionario/Rafael (Apagar um produto)
	@DELETE
	@Path("/{id}")
	public Response remover(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		try {
			service.remover(id);
			return Response.noContent().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	// PUT http://localhost:8080/07-WebApi/api/produto/Rafael (Atualizar um funcionario)
	@PUT
	@Path("/{nome}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Funcionario funcionario, @PathParam("nome") String nome)
			throws ClassNotFoundException, SQLException {
		try {
			service.atualizar(funcionario);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

}
