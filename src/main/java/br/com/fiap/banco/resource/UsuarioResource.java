package br.com.fiap.banco.resource;

import java.sql.SQLException;
import java.util.List;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Usuario;
import br.com.fiap.banco.service.UsuarioService;
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

@Path("/usuario") // http://localhost:8080/07-WebApi/api/usuario
public class UsuarioResource {

	private UsuarioService service;

	public UsuarioResource() throws ClassNotFoundException, SQLException {
		service = new UsuarioService();
	}

	// POST http://localhost:8080/07-WebApi/api/usuario/ (Cadastrar um
	// usuario)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Usuario usuario, @Context UriInfo uri)
			throws ClassNotFoundException, SQLException {
		try {
			service.cadastrar(usuario);
			// Recupera o path (URL atual(http://localhost:8080/07-WebApi/api/usuario/))
			UriBuilder uriBuilder = uri.getAbsolutePathBuilder();
			// Adiciona o nome do funcionario que foi criado na URL
			// uriBuilder.path(String.valueOf(usuario.getNome()));
			uriBuilder.path((usuario.getNome()));
			// Retornar o status 201 com a URL para acessar o usuario criado
			return Response.created(uriBuilder.build()).build();
		} catch (BadInfoException e) {
			e.printStackTrace();
			// Retornar o status 400 bad request
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	// GET http://localhost:8080/07-WebApi/api/usuario (Listar todos os
	// usuarios)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> lista() throws ClassNotFoundException, SQLException {
		return service.listar();
	}

	// DELETE http://localhost:8080/07-WebApi/api/usuario/Rafael (Apagar um produto)
	@DELETE
	@Path("/{nome}")
	public Response remover(@PathParam("nome") String nome) throws ClassNotFoundException, SQLException {
		try {
			service.remover(nome);
			return Response.noContent().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	// PUT http://localhost:8080/07-WebApi/api/usuario/Rafael (Atualizar um usuario)
	@PUT
	@Path("/{nome}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Usuario usuario, @PathParam("nome") String nome)
			throws ClassNotFoundException, SQLException {
		try {
			usuario.setNome(nome);
			service.atualizar(usuario);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
}