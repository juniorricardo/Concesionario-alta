package com.curso.spring.concesionaria.repository;

import com.curso.spring.concesionaria.dominio.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBicicletaRepo extends JpaRepository<Bicicleta, Long> {


}
