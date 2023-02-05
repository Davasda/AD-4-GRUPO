package com.edix.microssb.service;

import java.util.List;

import com.edix.microssb.entities.Pedido;


public interface PedidoService {
	
	List<Pedido> pedidosDeComercial (int idComercial);
	List <Pedido> buscarTodos();

}
