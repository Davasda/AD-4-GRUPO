package com.edix.restventas.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.restventas.modelo.entities.Pedido;
import com.edix.restventas.modelo.service.PedidoService;

@RestController
@RequestMapping ("/pedido")


public class PedidoRestController {
	
	@Autowired
	private PedidoService pServ;
	
	@GetMapping("/comercial/{id}")
	public List<Pedido> pedidosPorComercial (@PathVariable("id") int idComercial){
		return pServ.pedidosPorComercial(idComercial);
	}

}
