package com.edson.acompanharatividadesapi.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "atividades")
public class Atividade implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "nome", length = 100)
  private String nome;

  @Column(name = "data_termino")
  private String dataTermino;

  @Column(name = "finalizado")
  private Boolean finalizado;

  @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
  @JsonIgnore
  @JoinColumn(name = "grupo", nullable = false )
  private Grupo grupo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Grupo getGrupo() {
    return grupo;
  }

  public void setGrupo(Grupo grupo) {
    this.grupo = grupo;
  }

  public String getDataTermino() {
    return dataTermino;
  }

  public void setDataTermino(String dataTermino) {
    this.dataTermino = dataTermino;
  }

  public Boolean getFinalizado() {
    return finalizado;
  }

  public void setFinalizado(Boolean finalizado) {
    this.finalizado = finalizado;
  }

  
}
