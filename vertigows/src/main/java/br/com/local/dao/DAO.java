package br.com.local.dao;

import java.util.List;

public interface DAO<T> {
	
	void salvar(T t);
	
	void alterar(T t);
	
	List<T> consultarTodos();
	
	List<T> consultarPorNome(T t);
	
	T consultarPorCodigo(T t);
	
	void remover(T t);
}
