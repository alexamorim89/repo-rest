package br.com.local.restful.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.local.modelo.Cliente;
import br.com.local.service.ClienteService;
import br.com.local.service.RegraNegocioException;

@Path("/serviceCliente")
public class Clientews {


	private ClienteService	clienteService = new ClienteService();
	

	
	
	@GET
	@Produces("application/json")
	@Path("/clientes")	
	public List<Cliente> listarClientes(){
		return this.clienteService.consultarTodos();
	}
	
	
	@GET
	@Path("/cliente/id/{id}")
	@Produces("application/json")
	@Consumes("text/plain")
	public Cliente  consultaPorCodigo(@PathParam("id") Long codigo){
		return this.clienteService.getPorCodigo(codigo);
	}
	
	
	@POST
	@Path("/cliente")
	@Consumes("application/json")
	public void insereCliente(Cliente cliente){
		 try {
			this.clienteService.salvar(cliente);
		} catch (RegraNegocioException e) {
			e.printStackTrace();
		}
	}
	
	
	@PUT
	@Path("/cliente")
	@Produces("application/json")
	public void alterarCliente(Cliente cliente){
		try {
			this.clienteService.alterar(cliente);
		} catch (RegraNegocioException e) {
			e.printStackTrace();
		}
	}

	
	@DELETE
	@Path("/cliente/id/{id}")	
	@Produces("application/json")
	@Consumes("text/plain")
	public void removerCliente(@PathParam("id") Long id){
		Cliente cliente = new Cliente();
		try {			
			cliente.setId(id);
			this.clienteService.excluir(cliente);
		} catch (RegraNegocioException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
