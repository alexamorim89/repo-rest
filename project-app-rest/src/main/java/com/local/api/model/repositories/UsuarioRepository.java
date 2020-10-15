package com.local.api.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.api.model.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
