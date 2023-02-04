package com.edix.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.empresa.entities.Comerciale;

public interface ComercialRepository extends JpaRepository<Comerciale, Integer> {

	/**
	 * 	Devolvemos la lista de los comerciales que han atendido pedidos del cliente que coincida con ese id.
	 * @param idCliente
	 * @return
	 */
		
	@Query("select distinct c from Comerciale c, Pedido p where p.comerciale.idComercial= c and p.cliente.idCliente =?1")	
	List<Comerciale>	porCliente(int idCliente);
	
/**
 * Query desde la base de datos, en el cual sacamos la lista de comerciales que hayan realizado algun pedido
 * @return
 */
	@Query(value = "select distinct * from comerciales CO, pedidos P where CO.id_comercial=P.id_comercial and P.id_comercial is not null group by CO.id_comercial", 
			nativeQuery = true)
			List<Comerciale>	comercialesConPedidos();
}
