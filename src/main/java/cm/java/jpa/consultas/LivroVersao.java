package cm.java.jpa.consultas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "t_livro_versao")
public class LivroVersao {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  @Version
  private Integer versao;
  private String titulo;
  private Float preco;
  private String descricao;
  private String isbn;
  private Integer nroDePaginas;
  private Boolean ilustracoes;

  // ======================================
  // =            Construtores            =
  // ======================================

  public LivroVersao() {
  }

  public LivroVersao(String tituloParam, Float precoParam, String descricaoParam, String isbnParam, Integer nroDePaginasParam, Boolean ilustracoesParam) {
    titulo = tituloParam;
    preco = precoParam;
    descricao = descricaoParam;
    isbn = isbnParam;
    nroDePaginas = nroDePaginasParam;
    ilustracoes = ilustracoesParam;
  }

  // ======================================
  // =          Metodos Públicos          =
  // ======================================

  public void aumentoOPrecoEmDoisReais() {
    preco = preco + 2;
  }

  public void aumentoPrecoEmCincoReais() {
    preco = preco + 5;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public Integer getVersao() {
    return versao;
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