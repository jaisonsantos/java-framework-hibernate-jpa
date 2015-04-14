package cm.java.jpa.entidades;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "T_Livro_Etiqueta")
public class LivroColecaoList {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String titulo;
  private Float preco;
  private String descricao;
  private String isbn;
  private Integer nroDePaginas;
  private Boolean ilustracoes;
  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "t_etiquetas")
  // @Column(name = "Preco")
  private List<String> etiquetas = new ArrayList<>();

  // ======================================
  // =            Construtores            =
  // ======================================

  public LivroColecaoList() {
  }

  public LivroColecaoList(String titleParam, Float precoParam, String descricaoParam, String isbnParam, Integer nroDePaginasParam, Boolean ilustracoesParam, ArrayList<String> etiquetas) {
    this.titulo = titleParam;
    this.preco = precoParam;
    this.descricao = descricaoParam;
    this.isbn = isbnParam;
    this.nroDePaginas = nroDePaginasParam;
    this.ilustracoes = ilustracoesParam;
    this.etiquetas = etiquetas;
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

  public List<String> getEtiquetas() {
    return etiquetas;
  }

  public void setTags(ArrayList<String> etiquetas) {
    this.etiquetas = etiquetas;
  }
}