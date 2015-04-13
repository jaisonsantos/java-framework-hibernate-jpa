package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_livro_heranca_juntada")
public class LivroHerancaJuntada extends ItemHerancaJuntada {

  // ======================================
  // =             Atributos              =
  // ======================================

  private String isbn;
  private String editora;
  private Integer nroDePaginas;
  private Boolean ilustracoes;

  // ======================================
  // =            Construtores            =
  // ======================================

  public LivroHerancaJuntada() {
  }

  public LivroHerancaJuntada(String tituloParam, Float precoParam, String descricaoParam, String isbnParam, String editoraParam, Integer nroDePaginasParam, Boolean ilustracoesParam) {
    super(tituloParam, precoParam, descricaoParam);
    isbn = isbnParam;
    editora = editoraParam;
    nroDePaginas = nroDePaginasParam;
    ilustracoes = ilustracoesParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

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