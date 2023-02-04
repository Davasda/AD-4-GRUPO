package com.edix.empresa.service;

import java.util.List;

import com.edix.empresa.entities.Pedido;

public interface PedidoService {
	
	List<Pedido> pedidosPorComercial (int idComercial);
	List <Pedido> buscarTodosPedidos ();

}
