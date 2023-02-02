package com.edix.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.empresa.entities.Cliente;
import com.edix.empresa.entities.Comerciale;
import com.edix.empresa.entities.Pedido;
import com.edix.empresa.repository.ComercialRepository;
import com.edix.empresa.repository.PedidoRepository;
import com.edix.empresa.service.ComercialService;

@RestController
@RequestMapping("/comercial")
public class ComercialRestController {
	@Autowired
	private ComercialService cServ;
	@Autowired
	private PedidoRepository pRepo;
	@Autowired
	private ComercialRepository cRepo;
	
	/**
	 * Dar de alta el comercial mediante la @Query en la calase Comercial Service
	 * @param comercial
	 * @return
	 */
	@PostMapping("/alta")
	public Comerciale alta(@RequestBody Comerciale comercial) {
		return cServ.altaComercial(comercial); 	
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
	 * @return
	 */
	@DeleteMapping("/eliminar/{id}")
	public boolean eliminarUno(@PathVariable("id") int idComercial) {
		return cServ.eliminarComercial(idComercial);
	}

	/**
	 * Mediante el id de un cliente, sacar la lista de comerciales que han atendido algun pedido que haya hecho dicho cliente
	 * @param idCliente
	 * @return
	 */
	@GetMapping("/bycliente/{id}")
	public List<Comerciale> byCliente(@PathVariable("id") int idCliente) {
		return pRepo.porCliente(idCliente);
	}
	
	/**
	 * Sacar la lista de comerciales que hayan atendido algun pedido
	 * @return
	 */
	@GetMapping("/conpedidos")
	public List<Comerciale> comercialPedidos() {
		return cRepo.comercialesConPedidos();
	}
	
	/**
	 * Devolver todos los productos que haya atendido el comercial con ese id
	 * @param idComercial
	 * @return
	 */
	@GetMapping("/pedidos/{id}")
	public List<Pedido> porPedidos(@PathVariable("id") int idComercial) {
		return pRepo.pedidosPorComercial(idComercial);
	}
}
