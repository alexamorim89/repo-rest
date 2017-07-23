package br.com.local.service;

import java.util.List;

import br.com.local.dao.ClienteDAO;
import br.com.local.modelo.Cliente;

public class ClienteService implements Service<Cliente>{
	
//	@Inject
	private ClienteDAO clienteDAO = new ClienteDAO();
	

	@Override
	public void salvar(Cliente cliente) throws RegraNegocioException {
		this.clienteDAO.salvar(cliente);		
	}

	@Override
	public void alterar(Cliente cliente) throws RegraNegocioException {
		this.clienteDAO.alterar(cliente);		
	}

	@Override
	public void excluir(Cliente cliente) throws RegraNegocioException {
		this.clienteDAO.remover(cliente);		
	}

	@Override
	public List<Cliente> consultarTodos() {
		return this.clienteDAO.consultarTodos();
	}

	@Override
	public Cliente consultatPorCodigo(Cliente cliente) {
		return this.clienteDAO.consultarPorCodigo(cliente);
	}

	
	public Cliente getPorCodigo(Long id){
		return this.clienteDAO.getPorCodigo(id);
	}
	
	
}
