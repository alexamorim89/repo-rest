package com.local.api.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.api.model.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
