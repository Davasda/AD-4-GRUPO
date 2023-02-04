package com.edix.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.empresa.entities.Comerciale;
import com.edix.empresa.entities.Pedido;
import com.edix.empresa.service.ComercialService;
import com.edix.empresa.service.PedidoService;

@RestController
@RequestMapping("/comercial")
public class ComercialRestController {
	@Autowired
	private ComercialService cServ;
	@Autowired
	private PedidoService pServ;
	
	
	/**
	 * Dar de alta el comercial mediante la @Query en la calase Comercial Service
	 * @param comercial
	 * @return String que nos informa si el alta se ha realizado correctamente.
	 */
	@PostMapping("/alta")
	public String alta(@RequestBody Comerciale comercial) {
		return (cServ.altaComercial(comercial)) != null?"Alta de comercial REALIZADA":"Error al dar de alta comercial";
	}
	
	/**
	 * Ver la lista de todos los comerciales
	 * @return
	 */
	@GetMapping("/ver")
	public List<Comerciale> todos(){
		return cServ.buscarTodos();
	}
	
	/**
	 * Mediante el Id de un comercial, obtener sus datos
	 * @param idComercial
	 * @return
	 */
	@GetMapping("/uno/{id}")
	public Comerciale buscarUno(@PathVariable("id") int idComercial) {
		return cServ.buscarUno(idComercial);
	}
	
	/**
	 * Mediante el Id de un comercial, eliminarlo de la Base de Datos
	 * @param idComercial
	 * @return Devuelve un String con el texto de si el comercial ha sido o no eliminado.
	 */
	@DeleteMapping("/eliminar/{id}")
	public String eliminarUno(@PathVariable("id") int idComercial) {
		return (cServ.eliminarComercial(idComercial)) == true?"Comercial ELIMINADO":"Error eliminar el comercial";	
	}

	/**
	 * Mediante el id de un cliente, sacar la lista de comerciales que han atendido algun pedido que haya hecho dicho cliente
	 * @param idCliente
	 * @return
	 */
	@GetMapping("/bycliente/{id}")
	public List<Comerciale> byCliente(@PathVariable("id") int idCliente) {
		return cServ.porCliente(idCliente);
	}
	
	/**
	 * Sacar la lista de comerciales que hayan atendido algun pedido
	 * @return
	 */
	@GetMapping("/conpedidos")
	public List<Comerciale> comercialPedidos() {
		return cServ.comercialesConPedidos();
	}
	
	/**
	 * Devolver todos los pedidos que haya atendido el comercial con ese id
	 * @param idComercial
	 * @return
	 */
	@GetMapping("/pedidos/{id}")
	public List<Pedido> porPedidos(@PathVariable("id") int idComercial) {
		return pServ.pedidosPorComercial(idComercial);
	}
}
