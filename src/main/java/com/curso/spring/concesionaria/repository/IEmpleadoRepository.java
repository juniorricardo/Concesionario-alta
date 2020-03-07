package com.curso.spring.concesionaria.repository;

import com.curso.spring.concesionaria.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {

    public Optional<Empleado> findAllByNombre(String nombre);
}
