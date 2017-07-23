package br.com.local.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.local.modelo.Produto;
import br.com.local.util.jpa.JPAUtil;


public class ProdutoDAO implements DAO<Produto>, Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5942415063690419202L;
	
	

	private EntityManager manager = JPAUtil.getEntityManager();
	
	
	

	@Override	
	public void salvar(Produto produto) {
	  this.manager.getTransaction().begin();
	  this.manager.persist(produto);
	  this.manager.getTransaction().commit();
	}
	
	
//	@Transactional
	@Override
	public void alterar(Produto produto) {
		this.manager.getTransaction().begin();
		this.manager.merge(produto);
		this.manager.getTransaction().commit();
	}

	@Override
	public List<Produto> consultarTodos() {		
		return this.manager.createQuery("from Produto", Produto.class)
				.getResultList();
	}

	@Override
	public List<Produto> consultarPorNome(Produto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto consultarPorCodigo(Produto produto) {
		return this.manager.find(Produto.class, produto.getId());
	}
	
	
	public Produto getPorCodigo(Long id){
		return this.manager.find(Produto.class, id);
	}
	
	
	

	@Override
	public void remover(Produto produto) {
		produto = this.consultarPorCodigo(produto);
		this.manager.getTransaction().begin();
		this.manager.remove(produto);
		this.manager.getTransaction().commit();
		this.manager.flush();
	}

}
