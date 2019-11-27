package com.curso.spring.concesionaria.repository;

import com.curso.spring.concesionaria.dominio.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutoRepo extends JpaRepository<Auto,Long> {


//    List<Autos> findAllByModeloLikeOrMarcaLike(String modelo, String marca);

    List<Auto> findByModelo(String modelo);

	List<Auto> findAllByMarcaLikeOrModeloLike(String marca, String modelo);

//    List<Vehiculo> findAll();
//
    //List<Vehiculo> findAllByNameLikeOrSurnameLike(String name, String surname);

}
