package com.local.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.api.model.entities.Categoria;
import com.local.api.model.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id); 
		return categoria.get(); 
	}
	
	
}
