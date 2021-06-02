package com.edson.acompanharatividadesapi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name = "grupos")
public class Grupo implements Serializable 
{
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "nome")
  private String nome;

  @OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @Column(name = "atividade")
  private Set<Atividade> atividade;

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

  public Set<Atividade> getAtividade() {
    return atividade;
  }

  public void setAtividade(Set<Atividade> atividade) {
    this.atividade = atividade;
  }

}
