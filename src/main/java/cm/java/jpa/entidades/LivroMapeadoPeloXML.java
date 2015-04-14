package cm.java.jpa.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_livro_mapeado_xml")
public class LivroMapeadoPeloXML {

  // ======================================
  // =             Atributos              =
  // ======================================
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String titulo;
  private Float preco;
  @Column(length = 500)
  private String descricao;
  private String isbn;
  private Integer nroDePaginas;
  private Boolean ilustracoes;

  // ======================================
  // =            Construtores            =
  // ======================================

  public LivroMapeadoPeloXML() {
  }

  public LivroMapeadoPeloXML(String tituloParam, Float precoParam, String descricaoParam, String isbnParam, Integer nroDePaginasParam, Boolean ilustracoesParam) {
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