package com.edix.empresa.service;

import java.util.List;

import com.edix.empresa.entities.Comerciale;

public interface ComercialService {
	Comerciale altaComercial(Comerciale comercial);
	Comerciale buscarUno(int idComercial);
	List<Comerciale> buscarTodos();
	boolean eliminarComercial(int idComercial);
}
