package br.com.local.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.local.modelo.Cliente;
import br.com.local.util.jpa.JPAUtil;


public class ClienteDAO implements DAO<Cliente>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 563036018668787105L;
	
	
	
	private EntityManager manager = JPAUtil.getEntityManager();
	

	
//	@Transactional
	@Override
	public void salvar(Cliente cliente) {
		this.manager.getTransaction().begin();		
		this.manager.persist(cliente);		
		this.manager.getTransaction().commit();
	
	}
	
//	@Transactional
	@Override
	public void alterar(Cliente cliente) {
		this.manager.getTransaction().begin();
		this.manager.merge(cliente);
		this.manager.getTransaction().commit();
	}
	
	
	@Override
	public List<Cliente> consultarTodos() {
		return this.manager.createQuery("from Cliente", Cliente.class)
				.getResultList();
	}

	@Override
	public List<Cliente> consultarPorNome(Cliente t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente consultarPorCodigo(Cliente cliente) {
		return this.manager.find(Cliente.class, cliente.getId());
	}
	
	
	public Cliente getPorCodigo(Long id){
		return this.manager.find(Cliente.class, id);
	}
	
//	@Transactional
	@Override
	public void remover(Cliente cliente) {
		cliente = this.consultarPorCodigo(cliente);
		this.manager.getTransaction().begin();
		this.manager.remove(cliente);
		this.manager.getTransaction().commit();
	}
	
	
	

}
