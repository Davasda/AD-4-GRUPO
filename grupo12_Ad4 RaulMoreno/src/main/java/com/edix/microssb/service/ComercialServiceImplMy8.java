package com.edix.microssb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.microssb.entities.Comercial;
import com.edix.microssb.repository.ComercialRepository;

@Service
public class ComercialServiceImplMy8 implements ComercialService{
	
	@Autowired
	private ComercialRepository cRepo;
	
	@Override
	public Comercial altaComercial(Comercial comercial) {
		if (buscarUno(comercial.getIdComercial())==null)
			return cRepo.save(comercial);
		return null;
	}

	@Override
	public Comercial buscarUno(int idComercial) {
		return cRepo.findById(idComercial).orElse(null);
	}

	@Override
	public List<Comercial> buscarTodos() {
		return cRepo.findAll();
	}

	@Override
		public boolean eliminarUno(int idComercial) {
			try {	
				if (buscarUno(idComercial) != null) {
		}
				 cRepo.deleteById(idComercial);
				 return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public List<Comercial> porCliente(int idCliente) {
		return cRepo.porCliente(idCliente);
	}
	@Override
	public List<Comercial> conPedidos() {
		return cRepo.conPedidos();
	}
}
