package com.edix.microssb.service;

import java.util.List;

import com.edix.microssb.entities.Comercial;

public interface ComercialService {
		
	Comercial altaComercial (Comercial comercial);
    Comercial buscarUno(int idComercial);
    List<Comercial> buscarTodos();
    boolean eliminarUno(int idComercial);
    List<Comercial> conPedidos();
	List<Comercial> porCliente(int idCliente);

}
