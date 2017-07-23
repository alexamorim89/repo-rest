package br.com.local.service;

import java.io.Serializable;
import java.util.List;

import br.com.local.dao.ProdutoDAO;
import br.com.local.modelo.Produto;

public class ProdutoService implements Service<Produto> , Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3317743137782237154L;
	
	
	private ProdutoDAO ProdutoDAO = new ProdutoDAO();
	
   
	@Override
	public void salvar(Produto produto) throws RegraNegocioException {
		this.ProdutoDAO.salvar(produto);
	}

	@Override
	public void alterar(Produto produto) throws RegraNegocioException {
		this.ProdutoDAO.alterar(produto);
	}

	@Override
	public void excluir(Produto produto) throws RegraNegocioException {
		this.ProdutoDAO.remover(produto);		
	}

	@Override
	public List<Produto> consultarTodos() {
		return this.ProdutoDAO.consultarTodos();
	}

	@Override
	public Produto consultatPorCodigo(Produto produto) {
		return this.ProdutoDAO.consultarPorCodigo(produto);
	}

}
