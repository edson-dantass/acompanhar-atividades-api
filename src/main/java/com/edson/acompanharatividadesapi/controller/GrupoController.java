package com.edson.acompanharatividadesapi.controller;

import com.edson.acompanharatividadesapi.repository.GrupoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.edson.acompanharatividadesapi.model.Grupo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/api")
public class GrupoController {

  @Autowired
  GrupoRepository grupoRepository;

  @GetMapping(value="/grupos")
  public List<Grupo> index() {
      return grupoRepository.findAll();
  }

  @PostMapping(value="/grupo")
  public Grupo create(@RequestBody Grupo grupo) {
      return grupoRepository.save(grupo);
  }
  
  

  
}
