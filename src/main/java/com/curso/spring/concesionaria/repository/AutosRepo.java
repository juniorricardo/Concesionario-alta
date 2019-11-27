package com.curso.spring.concesionaria.repository;

import com.curso.spring.concesionaria.dominio.Autos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutosRepo extends JpaRepository<Autos,Long> {


    List<Autos> findAllByModeloLikeOrMarcaLike(String modelo, String marca);

//    List<Vehiculo> findAll();
//
    //List<Vehiculo> findAllByNameLikeOrSurnameLike(String name, String surname);

}
