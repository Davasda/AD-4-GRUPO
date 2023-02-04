package com.edix.restventas.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.restventas.modelo.entities.Comercial;
import com.edix.restventas.modelo.service.ComercialService;

@RestController
@RequestMapping("/comercial")
public class ComercialRestController {
	
	@Autowired
	private ComercialService cServ;
	
	@GetMapping("/todos")
	public List<Comercial> todos(){
		return cServ.buscarTodosComerciales();
	}
	
	@GetMapping("/uno/{id}")
	public Comercial buscarUno (@PathVariable("id") int idComercial) {
		return cServ.buscarUnComercial(idComercial);
	}
	
	@PostMapping("/alta")
	public String darAltaComercial (@RequestBody Comercial comercial) {
		return (cServ.altaComercial(comercial)) != null?"Alta de comercial REALIZADA":"Error al dar de alta comercial";
		
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarComercial (@PathVariable ("id") int idComercial) {
		return (cServ.eliminarComercial(idComercial)) == true?"Comercial ELIMINADO":"Error eliminar el comercial";
		
	}
	
	@GetMapping("/bycliente/{id}")
	public List<Comercial> comercialesPorClientes (@PathVariable("id") int idCliente) {
		return cServ.comercialesPorCliente(idCliente);
	}
	
	@PutMapping("/modificar")
	public String modificarComercial (@RequestBody Comercial comercial) {
		return (cServ.modificarComercial(comercial) != null)?"Comercial Modificado":"Error al modificar comercial";
		
	}
	
	@GetMapping("/conpedidos")
	public List<Comercial> comercialesConPedidos () {
		return cServ.comercialesConPedidos();
	}
	
	/*@GetMapping("/pedidos/{id}")
	public List<Pedido> pedidosPorComercial (@PathVariable("id") int idComercial){
		return cServ.pedidosPorComercial(idComercial);
	}*/
	
	

}
