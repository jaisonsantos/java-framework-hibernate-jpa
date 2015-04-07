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
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "t_noticia_ordenado")
public class NoticiaOrdenado {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String conteudo;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @OrderBy("dataPublicacao DESC")
  private List<ComentarioOrdenado> comentarios;

  // ======================================
  // =            Construtores            =
  // ======================================

  public NoticiaOrdenado() {
  }

  public NoticiaOrdenado(String conteudoParam) {
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

  public void adicionaComentario(ComentarioOrdenado comentario) {
    if (comentarios == null)
      comentarios = new ArrayList<ComentarioOrdenado>();
    comentarios.add(comentario);
  }

  public List<ComentarioOrdenado> getComentarios() {
    return comentarios;
  }
}