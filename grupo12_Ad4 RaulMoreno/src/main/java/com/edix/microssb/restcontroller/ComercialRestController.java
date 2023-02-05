package com.edix.microssb.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.microssb.repository.PedidoRepository;
import com.edix.microssb.repository.ComercialRepository;

import com.edix.microssb.service.ComercialService;
import com.edix.microssb.entities.Comercial;
import com.edix.microssb.entities.Pedido;



@RestController
@RequestMapping("/comercial")
public class ComercialRestController {
	
	@Autowired
	private ComercialService cServ;
	
	@Autowired
	private ComercialRepository pServ;
	
	
	
	@PostMapping("/alta")
	public Comercial alta(@RequestBody Comercial comercial) {
		return cServ.altaComercial(comercial); 	
	}

	@GetMapping("/verTodas")
	public List<Comercial> todos(){
		return cServ.buscarTodos();
	}

	@GetMapping("/verUno/{id}")
	public Comercial buscarUno(@PathVariable("id") int idComercial) {
		return cServ.buscarUno(idComercial);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarUno(@PathVariable("id") int idComercial) {
		if (cServ.eliminarUno(idComercial))
			return "Comercial Eliminado";
		else
			return "Comercial no eliminado o no existía";
		}
	
	@GetMapping("/byCliente/{id}")
	public List<Comercial> byCliente(@PathVariable("id") int idCliente) {
		return cServ.porCliente(idCliente);
	}
		

	@GetMapping("/conPedidos")
	public List<Comercial> comercialPedidos() {
		return cServ.conPedidos();
	}
		

	@GetMapping("/pedidos/{id}")
	public List<Pedido> porPedidos(@PathVariable("id") int idComercial) {
		return pServ.pedidosDeComercial(idComercial);
	}
	
}