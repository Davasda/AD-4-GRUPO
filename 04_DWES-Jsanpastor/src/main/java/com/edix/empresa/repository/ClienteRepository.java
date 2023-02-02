package com.edix.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.empresa.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
