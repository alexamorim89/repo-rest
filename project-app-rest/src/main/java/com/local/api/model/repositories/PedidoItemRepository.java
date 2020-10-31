package com.local.api.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.api.model.entities.PedidoItem;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

}
