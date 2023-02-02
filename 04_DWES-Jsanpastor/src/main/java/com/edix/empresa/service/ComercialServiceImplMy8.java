package com.edix.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.empresa.entities.Comerciale;
import com.edix.empresa.repository.ComercialRepository;

@Service
public class ComercialServiceImplMy8 implements ComercialService{
	
	@Autowired
	private ComercialRepository cRepo;
	/**
	 *Damos de alta el comercial, buscamos el comercial y si no existe lo añadimos a la lista y si existe, damos valor null
	 */
	@Override
	public Comerciale altaComercial( Comerciale comercial) {
		if (buscarUno(comercial.getIdComercial()) == null)
				return cRepo.save(comercial);
		return null;
	}
	/**
	 * Buscamos un comercial, mediante su id
	 */
	@Override
	public Comerciale buscarUno(int idComercial) {
		// TODO Auto-generated method stub
		return cRepo.findById(idComercial).orElse(null);
	}
	
	/**
	 * Buscamos todos los comerciales y lo devolvemos en forma de lista
	 */
	@Override
	public List<Comerciale> buscarTodos() {
		// TODO Auto-generated method stub
		return cRepo.findAll();
	}
	
	/**
	 * Buscamos un comercial y lo eliminamos mediante su id si existe
	 */
	@Override
	public boolean eliminarComercial(int idComercial) {
		if (buscarUno(idComercial) != null) {
			 cRepo.deleteById(idComercial);
		return true;
		}
		return false;
	}

}
