package com.curso.spring.concesionaria.repository;

import com.curso.spring.concesionaria.domain.Empleado_Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRegistroRepository extends JpaRepository<Empleado_Permiso,Integer> {



}
