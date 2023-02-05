package com.edix.microssb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.microssb.entities.Pedido;
import com.edix.microssb.repository.PedidoRepository;





@Service
public class PedidoServiceImplMy8 implements PedidoService {
	@Autowired
	private PedidoRepository pRepo;

	@Override
	public List<Pedido> pedidosDeComercial(int idComercial) {	
		return pRepo.pedidosDeComercial(idComercial);
	}
	
	
	@Override
	public List<Pedido> buscarTodos() {
		return pRepo.findAll();
	}
	

}
