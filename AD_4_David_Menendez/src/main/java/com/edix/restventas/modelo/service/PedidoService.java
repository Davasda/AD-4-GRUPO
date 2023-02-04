package com.edix.restventas.modelo.service;

import java.util.List;
import com.edix.restventas.modelo.entities.Pedido;

public interface PedidoService {
	
	List<Pedido> pedidosPorComercial (int idComercial);
	List <Pedido> buscarTodosPedidos ();

}
