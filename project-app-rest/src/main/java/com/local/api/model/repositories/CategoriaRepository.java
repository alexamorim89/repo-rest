package com.local.api.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.local.api.model.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
