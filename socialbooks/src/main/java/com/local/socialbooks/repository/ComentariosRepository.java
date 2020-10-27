package com.local.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.local.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
