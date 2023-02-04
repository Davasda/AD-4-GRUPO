package com.edix.restventas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.restventas.modelo.entities.Comercial;
import com.edix.restventas.modelo.entities.Pedido;
import com.edix.restventas.modelo.repository.ComercialRepository;

@Service
public class ComercialServiceImplMy8 implements ComercialService {

	@Autowired
	private ComercialRepository cRepo;
	@Override
	public Comercial altaComercial(Comercial comercial) {
		if (buscarUnComercial(comercial.getIdComercial())==null)
			return cRepo.save(comercial);
		else
			return null;
	}

	@Override
	public boolean eliminarComercial(int idComercial) {
		try{
			if (buscarUnComercial(idComercial)!=null) {
		}
			cRepo.deleteById(idComercial);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public Comercial buscarUnComercial(int idComercial) {
		// TODO Auto-generated method stub
		return cRepo.findById(idComercial).orElse(null);
	}

	@Override
	public List<Comercial> buscarTodosComerciales() {
		// TODO Auto-generated method stub
		return cRepo.findAll();
	}

	@Override
	public Comercial modificarComercial(Comercial comercial) {
		if (buscarUnComercial(comercial.getIdComercial())!=null)
			return cRepo.save(comercial);
		else
			return null;
	}

	@Override
	public List<Comercial> comercialesPorCliente(int idCliente) {
		
		return cRepo.comercialesPorCliente(idCliente);
	}

	@Override
	public List<Comercial> comercialesConPedidos() {
	
		return cRepo.comercialesConPedidos();
	}

	/*@Override
	public List<Pedido> pedidosPorComercial(int idComercial) {	
		return cRepo.pedidosPorComercial(idComercial);
	}*/

}
