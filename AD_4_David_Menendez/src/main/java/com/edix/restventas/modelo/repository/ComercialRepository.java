package com.edix.restventas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.restventas.modelo.entities.Comercial;
import com.edix.restventas.modelo.entities.Pedido;

public interface ComercialRepository extends JpaRepository<Comercial, Integer>{
	
	
	// Lista de comerciales han atendido a un cliente dado.
	@Query(	value= "select distinct * from comerciales CO, pedidos P where CO.id_comercial=P.id_comercial and P.id_cliente= ?1 group by CO.id_comercial",
			nativeQuery = true
			)
	public List<Comercial> comercialesPorCliente (int idCliente);
	
	// Lista de comerciales que tienen algún pedido.
	@Query(	value= "select distinct * from comerciales CO, pedidos P where CO.id_comercial=P.id_comercial and P.id_comercial is not null group by CO.id_comercial",
			nativeQuery = true
			)
	public List<Comercial> comercialesConPedidos ();
	
	/*@Query(	value= "select * from pedidos  WHERE id_comercial=?1",
			nativeQuery = true
			)
	public List<Pedido> pedidosPorComercial (int idComercial);*/
	
	
}
