package com.edson.acompanharatividadesapi.repository;

import java.util.List;

import com.edson.acompanharatividadesapi.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    @Query(value = "SELECT * FROM grupos;", nativeQuery = true)
    List<Grupo> findByNameGroup();
}
