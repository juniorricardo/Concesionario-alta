package com.curso.spring.concesionaria.repository;

import com.curso.spring.concesionaria.dominio.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {


    Vehiculo findByModeloLike(String modelo);

    //List<Vehiculo> findAllByLike(String name);

    //List<Vehiculo> findAllByNameLikeOrSurnameLike(String name, String surname);

}
