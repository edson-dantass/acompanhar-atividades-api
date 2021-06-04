package com.edson.acompanharatividadesapi.controller;
import com.edson.acompanharatividadesapi.model.Atividade;
import com.edson.acompanharatividadesapi.model.Grupo;
import com.edson.acompanharatividadesapi.repository.AtividadeRepository;
import com.edson.acompanharatividadesapi.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class AtividadeController {

  @Autowired
  AtividadeRepository atividadeRepository;

  @Autowired
  GrupoRepository grupoRepository;

  @PostMapping(value = "/atividade/{id}")
  public Atividade create(@RequestBody Atividade atividade, @PathVariable(value = "id") Long id) {

    Grupo grupo = grupoRepository.findById(id).orElse(new Grupo());

    atividade.setGrupo(grupo);
    
    return atividadeRepository.save(atividade);
  }
}
