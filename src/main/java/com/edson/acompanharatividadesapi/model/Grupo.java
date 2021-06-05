package com.edson.acompanharatividadesapi.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;import javax.persistence.GenerationType;

@Entity
@Table(name = "grupos")
public class Grupo implements Serializable 
{
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;

  @Column(name = "nome")
  private String nome;

  @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Atividade> atividades;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Atividade> getAtividade() {
    return atividades;
  }

  public void setAtividade(List<Atividade> atividades) {
    this.atividades = atividades;
  }

}
