package com.local.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.local.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
