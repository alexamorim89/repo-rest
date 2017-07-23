package br.com.local.service;

import java.util.List;

public interface Service<T> {
	
	void salvar(T t) throws RegraNegocioException;

	void alterar(T t) throws RegraNegocioException ;
	
	void excluir(T t) throws RegraNegocioException;

	List<T> consultarTodos();
	
	T consultatPorCodigo(T t);
}
