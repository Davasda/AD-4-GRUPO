package com.edix.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.empresa.entities.Comerciale;
import com.edix.empresa.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	


/**
 * Devolvemos la lista de pedidos gestionados por el comercial que coincida con ese id.
 * @param idComercial
 * @return
 */

@Query(value = "select* from pedidos where id_comercial = ?", nativeQuery = true)	
	List<Pedido>	pedidosPorComercial(int idComercial);

}
