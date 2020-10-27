package com.local.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.local.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

}
