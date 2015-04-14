package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_Livro_Heranca_Transiente")
public class LivroHerancaTransiente extends ItemHerancaTransiente {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  protected Long id;
  private String isbn;
  private String editora;
  private Integer nroDePaginas;
  private Boolean ilustracoes;

  // ======================================
  // =            Construtores            =
  // ======================================

  public LivroHerancaTransiente() {
  }

  public LivroHerancaTransiente(String tituloParam, Float precoParam, String descricaoParam, String isbnParam, String editoraParam, Integer nroDePaginasParam, Boolean ilustracoesParam) {
    super(tituloParam, precoParam, descricaoParam);
    isbn = isbnParam;
    editora = editoraParam;
    nroDePaginas = nroDePaginasParam;
    ilustracoes = ilustracoesParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getEditora() {
    return editora;
  }

  public void setEditora(String editora) {
    this.editora = editora;
  }

  public Integer getNbOfPage() {
    return nroDePaginas;
  }

  public void setNbOfPage(Integer nbOfPage) {
    this.nroDePaginas = nbOfPage;
  }

  public Boolean getIlustracoes() {
    return ilustracoes;
  }

  public void setIlustracoes(Boolean ilustracoes) {
    this.ilustracoes = ilustracoes;
  }
}