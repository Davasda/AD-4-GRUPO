package com.edix.restventas.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.restventas.modelo.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
