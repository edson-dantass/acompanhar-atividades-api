package com.edson.acompanharatividadesapi.repository;

import com.edson.acompanharatividadesapi.model.Atividade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
  
}
