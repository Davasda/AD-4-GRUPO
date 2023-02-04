package com.edix.restventas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.edix.restventas.modelo.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	// Lista de los pedidos de un comercial dado
	@Query(	value= "select * from pedidos  WHERE id_comercial=?1",
			nativeQuery = true
			)
	public List<Pedido> pedidosPorComercial (int idComercial);
}
