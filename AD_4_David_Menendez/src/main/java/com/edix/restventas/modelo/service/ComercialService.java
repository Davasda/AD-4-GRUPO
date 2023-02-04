package com.edix.restventas.modelo.service;

import java.util.List;

import com.edix.restventas.modelo.entities.Comercial;
import com.edix.restventas.modelo.entities.Pedido;

public interface ComercialService {

	Comercial altaComercial (Comercial comercial);
	
	boolean eliminarComercial (int idComercial);
	Comercial buscarUnComercial (int idComercial);
	List <Comercial> buscarTodosComerciales ();
	Comercial modificarComercial (Comercial comercial);
	List<Comercial> comercialesPorCliente (int idCliente);
	List <Comercial> comercialesConPedidos ();
	
	//List<Pedido> pedidosPorComercial (int idComercial);
	
}
