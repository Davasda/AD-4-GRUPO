package com.edix.restventas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.restventas.modelo.entities.Pedido;
import com.edix.restventas.modelo.repository.PedidoRepository;

@Service
public class PedidoServiceImplMy8 implements PedidoService {
	@Autowired
	private PedidoRepository pRepo;



	@Override
	public List<Pedido> buscarTodosPedidos() {

		return pRepo.findAll();
	}



	@Override
	public List<Pedido> pedidosPorComercial(int idComercial) {	
		return pRepo.pedidosPorComercial(idComercial);
	}
	

}
