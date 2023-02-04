package com.edix.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.empresa.entities.Pedido;
import com.edix.empresa.repository.PedidoRepository;



@Service
public class PedidoServiceImplMy8 implements PedidoService {
	@Autowired
	private PedidoRepository pRepo;

	@Override
	public List<Pedido> pedidosPorComercial(int idComercial) {	
		return pRepo.pedidosPorComercial(idComercial);
	}
	
	
	@Override
	public List<Pedido> buscarTodosPedidos() {
		return pRepo.findAll();
	}
	

}
