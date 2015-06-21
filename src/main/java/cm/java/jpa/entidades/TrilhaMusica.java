package cm.java.jpa.entidades;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


/**
 * Contém os atributos e construtores da entidade TrilhaMusica
 * @author jaison.santos
 */
@Entity
@Table(name = "T_Trilha_Musica")
public class TrilhaMusica {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String titulo;
  private Float duracao;
  @Basic(fetch = FetchType.LAZY)
  @Lob
  private byte[] musica;
  private String descricao;

  // ======================================
  // =            Construtores            =
  // ======================================

  public TrilhaMusica() {
  }

  public TrilhaMusica(String tituloParam, Float duracaoParam, String descricaoParam) {
    titulo = tituloParam;
    duracao = duracaoParam;
    descricao = descricaoParam;
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

  public Float getDuracao() {
    return duracao;
  }

  public void setDuracao(Float duracao) {
    this.duracao = duracao;
  }

  public byte[] getMusica() {
    return musica;
  }

  public void setMusica(byte[] musica) {
    this.musica = musica;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
