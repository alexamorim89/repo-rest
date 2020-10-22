package com.local.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.api.model.entities.Pedido;
import com.local.api.model.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id); 
		return pedido.get(); 
	}
	
	
}
