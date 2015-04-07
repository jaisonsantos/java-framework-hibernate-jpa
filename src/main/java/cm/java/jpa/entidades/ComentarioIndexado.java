package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_comentario_indexado")
public class ComentarioIndexado {

  // ======================================
  // =             Atributos              =
  // ======================================
  @Id
  @GeneratedValue
  private Long id;
  private String apelido;
  private String conteudo;
  private Integer nota;

  // ======================================
  // =            Construtores            =
  // ======================================

  public ComentarioIndexado() {
  }

  public ComentarioIndexado(String apelidoParam, String conteudoParam, Integer notaParam) {
    apelido = apelidoParam;
    conteudo = conteudoParam;
    nota = notaParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getApelido() {
    return apelido;
  }

  public void setApelido(String apelido) {
    this.apelido = apelido;
  }

  public String getConteudo() {
    return conteudo;
  }

  public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
  }

  public Integer getNota() {
    return nota;
  }

  public void setNota(Integer nota) {
    this.nota = nota;
  }
}