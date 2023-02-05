package com.edix.microssb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.microssb.entities.Comercial;
import com.edix.microssb.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	@Query("select distinct c from Comercial c, Pedido p where p.comercial.idComercial= c and p.cliente.idCliente =?1")	
	List<Comercial>	porCliente(int idCliente);
	
    @Query(value = "select * from pedidos where id_comercial = ?", nativeQuery = true)
    List<Pedido> pedidosDeComercial(int idComercial);
	

}
