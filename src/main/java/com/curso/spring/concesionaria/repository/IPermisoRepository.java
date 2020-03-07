package com.curso.spring.concesionaria.repository;

import com.curso.spring.concesionaria.domain.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermisoRepository extends JpaRepository<Permiso,Integer> {
}
