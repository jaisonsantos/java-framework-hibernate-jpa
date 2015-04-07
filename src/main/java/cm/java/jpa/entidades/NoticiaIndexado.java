package cm.java.jpa.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_noticia_indexado")
public class NoticiaIndexado {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String conteudo;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @OrderColumn(name = "indice_publicacao")
  private List<ComentarioIndexado> comentarios;

  // ======================================
  // =            Construtores            =
  // ======================================

  public NoticiaIndexado() {
  }

  public NoticiaIndexado(String conteudoParam) {
    conteudo = conteudoParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getConteudo() {
    return conteudo;
  }

  public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
  }

  public void adicionaComentario(ComentarioIndexado comentarioParam) {
    if (comentarios == null)
      comentarios = new ArrayList<ComentarioIndexado>();
    comentarios.add(comentarioParam);
  }

  public List<ComentarioIndexado> getComentarios() {
    return comentarios;
  }
}