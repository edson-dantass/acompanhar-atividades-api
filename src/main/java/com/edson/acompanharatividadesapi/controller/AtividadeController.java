package com.edson.acompanharatividadesapi.controller;
import com.edson.acompanharatividadesapi.model.Atividade;
import com.edson.acompanharatividadesapi.model.Grupo;
import com.edson.acompanharatividadesapi.repository.AtividadeRepository;
import com.edson.acompanharatividadesapi.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping(value = "/atividade/{id}")
  public Atividade show(@PathVariable(value = "id") Long id) {
    return atividadeRepository.findById(id).orElse(new Atividade());
  }

  @PostMapping(value = "/atividade/{id}")
  public Atividade create(@RequestBody Atividade atividade, @PathVariable(value = "id") Long id) {

    Grupo grupo = grupoRepository.findById(id).orElse(new Grupo());

    atividade.setGrupo(grupo);
    
    return atividadeRepository.save(atividade);
  }
  
  @DeleteMapping(value = "/atividade/{id}")
  public void destroy(@PathVariable(value = "id") Long id) {
    atividadeRepository.deleteById(id);
  }

  @PutMapping(value = "/atividade/{id}")
  public Atividade update(@RequestBody Atividade atividade, @PathVariable(value = "id") Long id) {
    Grupo grupo = grupoRepository.findById(id).orElse(new Grupo());
    Atividade atividadeEntity = atividadeRepository.findById(atividade.getId()).orElse(new Atividade());


    atividade.setDataTermino(atividadeEntity.getDataTermino());
    atividade.setNome(atividadeEntity.getNome());
    atividade.setFinalizado(atividadeEntity.getFinalizado());
    atividade.setGrupo(grupo);
    
    return atividadeRepository.save(atividade);

  }
}
