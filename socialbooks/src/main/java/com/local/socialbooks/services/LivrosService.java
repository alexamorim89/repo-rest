package com.local.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.local.socialbooks.domain.Comentario;
import com.local.socialbooks.domain.Livro;
import com.local.socialbooks.repository.ComentariosRepository;
import com.local.socialbooks.repository.LivrosRepository;
import com.local.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository 		livrosRepository;
	
	@Autowired
	private ComentariosRepository 	comentariosRepository;	
	
	public List<Livro> listar(){
		return this.livrosRepository.findAll();
	}	
	
	public Livro buscar(Long id){
		Livro livro = this.livrosRepository.findOne(id);
		
		//retorna erro 404 caso nao encontre o id do livro
		if(livro == null){
			throw new LivroNaoEncontradoException("O livro não pode ser encontrado.");
		}		
		return livro;
	}	
	
	public Livro salvar(Livro livro){
		livro.setId(null);
		return this.livrosRepository.save(livro);
	}	
	
	public void deletar(Long id){
		try{
			this.livrosRepository.delete(id);
		} catch(EmptyResultDataAccessException e){
			throw new LivroNaoEncontradoException("O livro não pode ser encontrado.");
		}
	}	
	
	public void atualizar(Livro livro){
		this.verificaExistencia(livro);
		livrosRepository.save(livro);
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario){
		Livro livro = this.buscar(livroId);
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return this.comentariosRepository.save(comentario);
	}
	
	public List<Comentario> listarComentarios(Long livroId){
		Livro livro = this.buscar(livroId);
		
		return livro.getComentarios();
	}	
	
	private void verificaExistencia(Livro livro){
		this.buscar(livro.getId());
	}	
}