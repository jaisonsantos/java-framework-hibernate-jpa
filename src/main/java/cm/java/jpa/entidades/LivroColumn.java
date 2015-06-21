package cm.java.jpa.entidades;

import javax.persistence.*;

/**
 * Contém os atributos e construtores da entidade LivroColumn
 * @author jaison.santos
 */
@Entity
@Table(name = "T_Livros")
public class LivroColumn {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "livro_titulo", nullable = false, updatable = false)
  private String titulo;
  private Float preco;
  @Column(length = 2000)
  private String descricao;
  private String isbn;
  @Column(name = "nro_de_paginas", nullable = false)
  private Integer nroDePaginas;
  private Boolean ilustracoes;

  // ======================================
  // =            Construtores            =
  // ======================================

  public LivroColumn() {
  }

  public LivroColumn(String tituloParam, Float precoParam, String descricaoParam, String isbnParam, Integer nroDePaginasParam, Boolean ilustracoesParam) {
    titulo = tituloParam;
    preco = precoParam;
    descricao = descricaoParam;
    isbn = isbnParam;
    nroDePaginas = nroDePaginasParam;
    ilustracoes = ilustracoesParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Float getPreco() {
    return preco;
  }

  public void setPreco(Float preco) {
    this.preco = preco;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Integer getNroDePaginas() {
    return nroDePaginas;
  }

  public void setNroDePaginas(Integer nroDePaginas) {
    this.nroDePaginas = nroDePaginas;
  }

  public Boolean getIlustracoes() {
    return ilustracoes;
  }

  public void setIlustracoes(Boolean ilustracoes) {
    this.ilustracoes = ilustracoes;
  }
}