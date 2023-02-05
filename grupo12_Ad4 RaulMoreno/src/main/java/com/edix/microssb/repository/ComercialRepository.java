package com.edix.microssb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.microssb.entities.Comercial;


public interface ComercialRepository extends JpaRepository<Comercial, Integer>{
	
	@Query("select distinct c from Comercial c, Pedido p where p.comercial.idComercial= c and p.cliente.idCliente =?1")	
	List<Comercial>	porCliente(int idCliente);
	

	@Query(value = "select distinct * from comerciales CO, pedidos P where CO.id_comercial=P.id_comercial and P.id_comercial is not null group by CO.id_comercial", 
			nativeQuery = true)
			List<Comercial>	conPedidos();
}
