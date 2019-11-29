package com.curso.spring.concesionaria.repository;

import com.curso.spring.concesionaria.dominio.Bicicleta;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBicicletaRepo extends JpaRepository<Bicicleta, Long> {

    List<Bicicleta> findByMarcaLike(String s);

    @Query("select * from test where marca = ?1 And modelo like ?2")
    Bicicleta find2(String marca, String s);
}
