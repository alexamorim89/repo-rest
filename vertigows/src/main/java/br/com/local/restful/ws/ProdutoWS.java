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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.local.modelo.Produto;
import br.com.local.service.ProdutoService;
import br.com.local.service.RegraNegocioException;

@Path("/serviceProduto")
public class ProdutoWS {

	
	private ProdutoService produtoService = new ProdutoService();
	
	
	
	@GET
	@Path("/produtos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> consultarTodos(){
		return this.produtoService.consultarTodos();
	}
	
	
	@GET
	@Path("/produto/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Produto consultaPorCodigo(@PathParam("id") Long id){
		Produto produto = new Produto();
		produto.setId(id);
		return this.produtoService.consultatPorCodigo(produto);
	}
	
	
	@POST
	@Path("/produto")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insereProduto(Produto produto){
		try {
			this.produtoService.salvar(produto);
		} catch (RegraNegocioException e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Path("/produto")
	@Produces(MediaType.APPLICATION_JSON)
	public void alterarProduto(Produto produto){
		try {
			this.produtoService.alterar(produto);
		} catch (RegraNegocioException e) {
			e.printStackTrace();
		}
	}
	
	
	@DELETE
	@Path("/produto/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public void removerProduto(@PathParam("id") Long id){
		Produto produto = new Produto();
		try {
			produto.setId(id);
			this.produtoService.excluir(produto);
		} catch (RegraNegocioException e) {
			e.printStackTrace();
		}
	}
	
	
	@GET
	@Path("/produto")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Produto getId(@QueryParam("id") Long id){
		Produto produto = new Produto();
		produto.setId(id);
		return this.produtoService.consultatPorCodigo(produto);
	}
	
	
	
	
}
