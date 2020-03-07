package com.curso.spring.concesionaria.repository;

import com.curso.spring.concesionaria.domain.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBicicletaRepo extends JpaRepository<Bicicleta, Long> {

    List<Bicicleta> findByMarcaLike(String s);

    Bicicleta findByMarcaAndModelo(String marca, String modelo);

    Bicicleta findByMarcaAndModeloLike(String s, String s1);
}
